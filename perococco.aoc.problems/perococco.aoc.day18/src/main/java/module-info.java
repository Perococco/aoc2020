import perococco.aoc.api.AOCProblem;
import perococco.aoc.day18.Day18Part1Solver;
import perococco.aoc.day18.Day18Part2Solver;

module perococco.aoc.day18 {
    requires static lombok;

    requires perococco.aoc.input;

    exports perococco.aoc.day18;
    exports perococco.aoc.day18.structures to perococco.aoc.input;

    provides AOCProblem with Day18Part1Solver, Day18Part2Solver;
}
