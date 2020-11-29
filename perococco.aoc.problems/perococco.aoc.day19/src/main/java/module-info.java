import perococco.aoc.day19.Day19Part1Solver;
import perococco.aoc.day19.Day19Part2Solver;
import perococco.aoc.api.AOCProblem;

module perococco.aoc.day19 {
    requires static lombok;

    requires perococco.aoc.input;

    exports perococco.aoc.day19;

    provides AOCProblem with Day19Part1Solver, Day19Part2Solver;
}
