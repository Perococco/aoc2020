import perococco.aoc.api.AOCProblem;
import perococco.aoc.day24.Day24Part1Solver;
import perococco.aoc.day24.Day24Part2Solver;

module perococco.aoc.day24 {
    requires static lombok;

    requires perococco.aoc.input;
    requires com.google.common;

    exports perococco.aoc.day24;
    exports perococco.aoc.day24.structures to perococco.aoc.input;

    provides AOCProblem with Day24Part1Solver, Day24Part2Solver;
}
