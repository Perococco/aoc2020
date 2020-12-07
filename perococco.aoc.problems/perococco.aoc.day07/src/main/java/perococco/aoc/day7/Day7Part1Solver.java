package perococco.aoc.day7;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day7.structures.BagGraph;

public class Day7Part1Solver extends Day7Solver {

    @Override
    public @NonNull Long solve(@NonNull BagGraph bagGraph) {
        return bagGraph.countContainers("shiny gold");
    }

    public static @NonNull AOCProblem<?> provider() {
        return new Day7Part1Solver().createProblem();
    }

}
