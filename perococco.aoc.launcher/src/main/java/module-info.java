import perococco.aoc.api.AOCProblem;

module perococco.aoc.launcher {
    requires static lombok;

    requires perococco.aoc.api;
    requires perococco.aoc.common;

    exports perococco.aoc.launcher;
    uses AOCProblem;
}
