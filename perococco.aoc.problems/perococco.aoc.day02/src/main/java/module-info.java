import perococco.aoc.api.AOCProblem;
import perococco.aoc.day2.Day2Part1Solver;
import perococco.aoc.day2.Day2Part2Solver;

module perococco.aoc.day2 {
    requires static lombok;

    requires perococco.aoc.input;

    exports perococco.aoc.day2;
    exports perococco.aoc.day2.structures to perococco.aoc.input;

    provides AOCProblem with Day2Part1Solver, Day2Part2Solver;
}
