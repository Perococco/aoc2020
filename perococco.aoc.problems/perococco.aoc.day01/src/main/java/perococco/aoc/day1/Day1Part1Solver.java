package perococco.aoc.day1;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Day1Part1Solver extends SmartSolver<IntStream, Long> {

    public static AOCProblem<?> provider() {
        return new Day1Part1Solver().createProblem();
    }

    @Override
    protected @NonNull Converter<IntStream> getConverter() {
        return Converter.TO_INT_STREAM;
    }

    @Override
    public @NonNull Long solve(@NonNull IntStream input) {
        final var seen = new boolean[2021];
        Arrays.fill(seen, false);
        return input.mapToLong(i -> {
            if (i < 0 || i >= 2020 || seen[i]) {
                return -1;
            }
            seen[i] = true;
            final int complement = 2020-i;
            if (seen[complement]) {
                return complement*i;
            }
            return -1;
        }).filter(p -> p >= 0).findFirst().orElse(-1L);
    }
}
