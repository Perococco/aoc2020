package perococco.aoc.day1;

import lombok.NonNull;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;
import perococco.aoc.api.AOCProblem;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day1Part2Solver extends SmartSolver<Stream<String>, Object> {

    public static AOCProblem<?> provider() {
        return new Day1Part2Solver().createProblem().skipped();
    }

    @Override
    protected @NonNull Converter<Stream<String>> getConverter() {
        return s -> s;
    }

    @Override
    public @NonNull Object solve(@NonNull Stream<String> input) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

}
