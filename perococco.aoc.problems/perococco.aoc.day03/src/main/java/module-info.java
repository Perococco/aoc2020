import perococco.aoc.api.AOCProblem;
import perococco.aoc.day3.Day3Part1Solver;
import perococco.aoc.day3.Day3Part2Solver;

module perococco.aoc.day3 {
    requires static lombok;

    requires perococco.aoc.input;

    exports perococco.aoc.day3;

    provides AOCProblem with Day3Part1Solver, Day3Part2Solver;
}
