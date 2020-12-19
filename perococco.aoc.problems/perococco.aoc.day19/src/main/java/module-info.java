import perococco.aoc.api.AOCProblem;
import perococco.aoc.day19.Day19Part1Solver;
import perococco.aoc.day19.Day19Part2Solver;

module perococco.aoc.day19 {
    requires static lombok;

    requires perococco.aoc.input;

    requires com.google.common;

    exports perococco.aoc.day19;
    exports perococco.aoc.day19.structures to perococco.aoc.input;

    provides AOCProblem with Day19Part1Solver, Day19Part2Solver;

}
