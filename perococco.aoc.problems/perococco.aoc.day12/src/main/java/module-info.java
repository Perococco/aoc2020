import perococco.aoc.api.AOCProblem;
import perococco.aoc.day12.Day12Part1Solver;
import perococco.aoc.day12.Day12Part2Solver;

module perococco.aoc.day12 {
    requires static lombok;

    requires perococco.aoc.input;

    requires com.google.common;

    exports perococco.aoc.day12;

    provides AOCProblem with Day12Part1Solver, Day12Part2Solver;
}
