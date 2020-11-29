import perococco.aoc.api.AOCProblem;
import perococco.aoc.day9.Day9Part1Solver;
import perococco.aoc.day9.Day9Part2Solver;

module perococco.aoc.day9 {
    requires static lombok;

    requires perococco.aoc.input;

    exports perococco.aoc.day9;

    provides AOCProblem with Day9Part1Solver, Day9Part2Solver;
}
