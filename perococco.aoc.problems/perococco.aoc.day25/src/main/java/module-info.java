import perococco.aoc.day25.Day25Part1Solver;
import perococco.aoc.day25.Day25Part2Solver;
import perococco.aoc.api.AOCProblem;

module perococco.aoc.day25 {
    requires static lombok;

    requires perococco.aoc.input;

    exports perococco.aoc.day25;

    provides AOCProblem with Day25Part1Solver, Day25Part2Solver;
}
