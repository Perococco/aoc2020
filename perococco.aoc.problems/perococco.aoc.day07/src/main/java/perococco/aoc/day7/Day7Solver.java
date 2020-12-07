package perococco.aoc.day7;

import lombok.NonNull;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day7Solver<O> extends SmartSolver<Stream<String>,O> {

    @Override
    protected @NonNull Converter<Stream<String>> getConverter() {
        return s -> s;
    }
}
