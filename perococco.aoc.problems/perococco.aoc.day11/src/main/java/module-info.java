import perococco.aoc.day11.Day11Part1Solver;
import perococco.aoc.day11.Day11Part2Solver;
import perococco.aoc.api.AOCProblem;

module perococco.aoc.day11 {
    requires static lombok;

    requires perococco.aoc.input;

    exports perococco.aoc.day11;

    provides AOCProblem with Day11Part1Solver, Day11Part2Solver;
}
