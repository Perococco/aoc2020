import perococco.aoc.day4.Day4Part1Solver;
import perococco.aoc.day4.Day4Part2Solver;
import perococco.aoc.api.AOCProblem;

module perococco.aoc.day4 {
    requires static lombok;

    requires perococco.aoc.input;

    exports perococco.aoc.day4;

    provides AOCProblem with Day4Part1Solver, Day4Part2Solver;
}
