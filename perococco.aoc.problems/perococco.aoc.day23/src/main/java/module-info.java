import perococco.aoc.api.AOCProblem;
import perococco.aoc.day23.Day23Part1Solver;
import perococco.aoc.day23.Day23Part2Solver;

module perococco.aoc.day23 {
    requires static lombok;

    requires perococco.aoc.input;

    exports perococco.aoc.day23;

    provides AOCProblem with Day23Part1Solver, Day23Part2Solver;
}
