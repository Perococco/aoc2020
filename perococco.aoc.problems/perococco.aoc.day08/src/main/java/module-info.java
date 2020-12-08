import perococco.aoc.api.AOCProblem;
import perococco.aoc.day8.Day8Part1Solver;
import perococco.aoc.day8.Day8Part2Solver;

module perococco.aoc.day8 {
    requires static lombok;

    requires perococco.aoc.input;

    requires com.google.common;

    exports perococco.aoc.day8;

    provides AOCProblem with Day8Part1Solver, Day8Part2Solver;
}
