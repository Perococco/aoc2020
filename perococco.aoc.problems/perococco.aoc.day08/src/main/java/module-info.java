import perococco.aoc.day8.Day8Part1Solver;
import perococco.aoc.day8.Day8Part2Solver;
import perococco.aoc.api.AOCProblem;

module perococco.aoc.day8 {
    requires static lombok;

    requires perococco.aoc.input;

    exports perococco.aoc.day8;

    provides AOCProblem with Day8Part1Solver, Day8Part2Solver;
}
