package perococco.aoc.day9;

import lombok.NonNull;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

public abstract class Day9Solver extends SmartSolver<long[],Long> {

    @Override
    protected @NonNull Converter<long[]> getConverter() {
        return Converter.TO_ARRAY_OF_LONG;
    }
}
