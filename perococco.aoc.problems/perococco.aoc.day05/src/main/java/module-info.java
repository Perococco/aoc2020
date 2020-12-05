import perococco.aoc.api.AOCProblem;
import perococco.aoc.day5.Day5Part1Solver;
import perococco.aoc.day5.Day5Part2Solver;

module perococco.aoc.day5 {
    requires static lombok;

    requires perococco.aoc.input;
    requires com.google.common;

    exports perococco.aoc.day5;

    provides AOCProblem with Day5Part1Solver, Day5Part2Solver;
}
