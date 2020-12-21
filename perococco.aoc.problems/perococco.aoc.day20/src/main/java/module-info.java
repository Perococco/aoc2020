import perococco.aoc.api.AOCProblem;
import perococco.aoc.day20.Day20Part1Solver;
import perococco.aoc.day20.Day20Part2Solver;

module perococco.aoc.day20 {
    requires static lombok;

    requires perococco.aoc.input;
    requires com.google.common;

    exports perococco.aoc.day20;

    provides AOCProblem with Day20Part1Solver, Day20Part2Solver;
}
