import perococco.aoc.api.AOCProblem;
import perococco.aoc.day22.Day22Part1Solver;
import perococco.aoc.day22.Day22Part2Solver;

module perococco.aoc.day22 {
    requires static lombok;

    requires perococco.aoc.input;
    requires com.google.common;

    exports perococco.aoc.day22;

    provides AOCProblem with Day22Part1Solver, Day22Part2Solver;
}
