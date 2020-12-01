import perococco.aoc.api.AOCProblem;
import perococco.aoc.day1.Day1Part1Solver;
import perococco.aoc.day1.Day1Part2Solver;

module perococco.aoc.day1 {
    requires static lombok;
    requires perococco.aoc.input;

    requires com.google.common;
    exports perococco.aoc.day1;

    provides AOCProblem with Day1Part1Solver, Day1Part2Solver;
}
