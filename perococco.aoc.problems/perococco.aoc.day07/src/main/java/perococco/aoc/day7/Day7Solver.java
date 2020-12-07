package perococco.aoc.day7;

import lombok.NonNull;
import perococco.aoc.day7.structures.BagGraph;
import perococco.aoc.day7.structures.BagGraphBuilder;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

public abstract class Day7Solver extends SmartSolver<BagGraph,Long> {

    @Override
    protected @NonNull Converter<BagGraph> getConverter() {
        return Converter.ALL_LINES.andThen(BagGraphBuilder::build);
    }
}
