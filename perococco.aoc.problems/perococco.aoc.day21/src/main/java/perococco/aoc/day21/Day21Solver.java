package perococco.aoc.day21;

import lombok.NonNull;
import perococco.aoc.day21.structures.Guide;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

public abstract class Day21Solver<O> extends SmartSolver<Guide,O> {

    @Override
    protected @NonNull Converter<Guide> getConverter() {
        return s -> s.collect(Guide.collector());
    }
}
