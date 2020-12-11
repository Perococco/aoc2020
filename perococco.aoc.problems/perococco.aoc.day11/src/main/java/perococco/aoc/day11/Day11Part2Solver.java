package perococco.aoc.day11;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.GridHelper;
import perococco.aoc.common.Tools;
import perococco.aoc.day11.structures.*;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.stream.Stream;

import static perococco.aoc.common.Tools.TODO;

public class Day11Part2Solver extends Day11Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day11Part2Solver().createProblem();
    }

    @Override
    protected @NonNull AdjacentCounter createCounter(@NonNull GridHelper gridHelper) {
        return new ViewableCounter(gridHelper);
    }

    @Override
    protected @NonNull StateEvolutionRule createEvolutionRule() {
        return new WithLeavingThresholdRule(5);
    }

}
