import perococco.aoc.day6.Day6Part1Solver;
import perococco.aoc.day6.Day6Part2Solver;
import perococco.aoc.api.AOCProblem;

module perococco.aoc.day6 {
    requires static lombok;

    requires perococco.aoc.input;

    exports perococco.aoc.day6;

    provides AOCProblem with Day6Part1Solver, Day6Part2Solver;
}
