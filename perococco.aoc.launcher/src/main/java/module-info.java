import perococco.aoc.api.AOCProblem;

module perococco.aoc.launcher {
    requires static lombok;

    requires perococco.aoc.api;
    requires perococco.aoc.common;

    requires com.google.common;

    exports perococco.aoc.launcher;
    uses AOCProblem;
}
