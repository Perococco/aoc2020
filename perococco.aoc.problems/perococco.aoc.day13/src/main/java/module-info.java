import perococco.aoc.api.AOCProblem;
import perococco.aoc.day13.Day13Part1Solver;
import perococco.aoc.day13.Day13Part2Solver;

module perococco.aoc.day13 {
    requires static lombok;

    requires perococco.aoc.input;
    requires com.google.common;

    exports perococco.aoc.day13;

    provides AOCProblem with Day13Part1Solver, Day13Part2Solver;
}
