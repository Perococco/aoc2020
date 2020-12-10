package perococco.aoc.day10;

import lombok.NonNull;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

public abstract class Day10Solver extends SmartSolver<int[],Long> {

    @Override
    protected @NonNull Converter<int[]> getConverter() {
        return Converter.TO_ARRAY_OF_INT;
    }
}
