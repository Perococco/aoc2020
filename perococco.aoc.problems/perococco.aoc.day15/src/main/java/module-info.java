import perococco.aoc.day15.Day15Part1Solver;
import perococco.aoc.day15.Day15Part2Solver;
import perococco.aoc.api.AOCProblem;

module perococco.aoc.day15 {
    requires static lombok;

    requires perococco.aoc.input;

    exports perococco.aoc.day15;

    provides AOCProblem with Day15Part1Solver, Day15Part2Solver;
}
