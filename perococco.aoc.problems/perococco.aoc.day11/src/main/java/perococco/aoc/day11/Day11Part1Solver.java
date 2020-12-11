package perococco.aoc.day11;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.GridHelper;
import perococco.aoc.day11.structures.*;

public class Day11Part1Solver extends Day11Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day11Part1Solver().createProblem();
    }

    @Override
    protected @NonNull AdjacentCounter createCounter(@NonNull GridHelper gridHelper) {
        return new AroundAdjacentCounter(gridHelper);
    }

    @Override
    protected @NonNull StateEvolutionRule createEvolutionRule() {
        return new WithLeavingThresholdRule(4);
    }

}
