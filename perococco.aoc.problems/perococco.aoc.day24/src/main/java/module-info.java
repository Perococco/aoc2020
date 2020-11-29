import perococco.aoc.day24.Day24Part1Solver;
import perococco.aoc.day24.Day24Part2Solver;
import perococco.aoc.api.AOCProblem;

module perococco.aoc.day24 {
    requires static lombok;

    requires perococco.aoc.input;

    exports perococco.aoc.day24;

    provides AOCProblem with Day24Part1Solver, Day24Part2Solver;
}
