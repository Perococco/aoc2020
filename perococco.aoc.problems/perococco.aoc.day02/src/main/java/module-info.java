import perococco.aoc.day2.Day2Part1Solver;
import perococco.aoc.day2.Day2Part2Solver;
import perococco.aoc.api.AOCProblem;

module perococco.aoc.day2 {
    requires static lombok;

    requires perococco.aoc.input;

    exports perococco.aoc.day2;

    provides AOCProblem with Day2Part1Solver, Day2Part2Solver;
}
