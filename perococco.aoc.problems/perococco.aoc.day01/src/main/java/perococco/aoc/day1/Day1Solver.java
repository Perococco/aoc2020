package perococco.aoc.day1;

import lombok.NonNull;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.stream.IntStream;

public abstract class Day1Solver<O> extends SmartSolver<int[],O> {

    @Override
    protected @NonNull
    Converter<int[]> getConverter() {
        return Converter.TO_INT_STREAM.andThen(IntStream::toArray);
    }


}
