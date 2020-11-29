import perococco.aoc.api.AOCProblem;
import perococco.aoc.day17.Day17Part1Solver;
import perococco.aoc.day17.Day17Part2Solver;

module perococco.aoc.day17 {
    requires static lombok;

    requires perococco.aoc.input;

    exports perococco.aoc.day17;

    provides AOCProblem with Day17Part1Solver, Day17Part2Solver;
}
