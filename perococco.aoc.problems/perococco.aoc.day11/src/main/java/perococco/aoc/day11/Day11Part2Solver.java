package perococco.aoc.day11;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.GridHelper;
import perococco.aoc.day11.structures.AdjacentCounter;
import perococco.aoc.day11.structures.StateEvolutionRule;
import perococco.aoc.day11.structures.algo.OptimizedViewableCounter;
import perococco.aoc.day11.structures.algo.WithLeavingThresholdRule;

public class Day11Part2Solver extends Day11Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day11Part2Solver().createProblem();
    }

    @Override
    protected @NonNull AdjacentCounter createCounter(@NonNull GridHelper gridHelper) {
        return new OptimizedViewableCounter(gridHelper);
    }

    @Override
    protected @NonNull StateEvolutionRule createEvolutionRule() {
        return new WithLeavingThresholdRule(5);
    }

}
