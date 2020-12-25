import perococco.aoc.api.AOCProblem;
import perococco.aoc.day25.Day25Part1Solver;
import perococco.aoc.day25.Day25Part2Solver;

module perococco.aoc.day25 {
    requires static lombok;

    requires perococco.aoc.input;
    requires com.google.common;

    exports perococco.aoc.day25;

    provides AOCProblem with Day25Part1Solver, Day25Part2Solver;
}
