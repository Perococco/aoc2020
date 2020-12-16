import perococco.aoc.api.AOCProblem;
import perococco.aoc.day16.Day16Part1Solver;
import perococco.aoc.day16.Day16Part2Solver;

module perococco.aoc.day16 {
    requires static lombok;

    requires perococco.aoc.input;
    requires com.google.common;

    exports perococco.aoc.day16;

    provides AOCProblem with Day16Part1Solver, Day16Part2Solver;
}
