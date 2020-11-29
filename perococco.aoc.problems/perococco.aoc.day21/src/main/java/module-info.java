import perococco.aoc.api.AOCProblem;
import perococco.aoc.day21.Day21Part1Solver;
import perococco.aoc.day21.Day21Part2Solver;

module perococco.aoc.day21 {
    requires static lombok;

    requires perococco.aoc.input;

    exports perococco.aoc.day21;

    provides AOCProblem with Day21Part1Solver, Day21Part2Solver;
}
