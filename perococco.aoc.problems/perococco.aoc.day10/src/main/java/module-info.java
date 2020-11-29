import perococco.aoc.day10.Day10Part1Solver;
import perococco.aoc.day10.Day10Part2Solver;
import perococco.aoc.api.AOCProblem;

module perococco.aoc.day10 {
    requires static lombok;

    requires perococco.aoc.input;

    exports perococco.aoc.day10;

    provides AOCProblem with Day10Part1Solver, Day10Part2Solver;
}
