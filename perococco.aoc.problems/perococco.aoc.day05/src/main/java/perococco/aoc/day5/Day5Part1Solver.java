package perococco.aoc.day5;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.stream.Stream;

public class Day5Part1Solver extends SmartSolver<Stream<String>,Object> {

    public static @NonNull AOCProblem<?> provider() {
        return new Day5Part1Solver().createProblem().skipped();
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
