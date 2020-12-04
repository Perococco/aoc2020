package perococco.aoc.day5;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day5Solver<O> extends SmartSolver<Stream<String>,O> {

    @Override
    protected @NonNull Converter<Stream<String>> getConverter() {
        return s -> s;
    }

}
