import perococco.aoc.api.AOCProblem;
import perococco.aoc.day4.Day4Part1Solver;
import perococco.aoc.day4.Day4Part2Solver;

module perococco.aoc.day4 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.input;

    exports perococco.aoc.day4;

    provides AOCProblem with Day4Part1Solver, Day4Part2Solver;
}
