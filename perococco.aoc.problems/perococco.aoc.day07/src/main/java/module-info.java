import perococco.aoc.api.AOCProblem;
import perococco.aoc.day7.Day7Part1Solver;
import perococco.aoc.day7.Day7Part2Solver;

module perococco.aoc.day7 {
    requires static lombok;

    requires perococco.aoc.input;
    requires com.google.common;

    exports perococco.aoc.day7;
    exports perococco.aoc.day7.structures to perococco.aoc.input;

    provides AOCProblem with Day7Part1Solver, Day7Part2Solver;
}
