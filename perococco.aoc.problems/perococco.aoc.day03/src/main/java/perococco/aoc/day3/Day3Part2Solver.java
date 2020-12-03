package perococco.aoc.day3;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.ArrayOfChar;
import perococco.aoc.common.Displacement;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.stream.Stream;

public class Day3Part2Solver extends SmartSolver<TreeCounter, Long> {

    public static @NonNull AOCProblem<?> provider() {
        return new Day3Part2Solver().createProblem();
    }

    @Override
    protected @NonNull Converter<TreeCounter> getConverter() {
        return Converter.TO_ARRAY_OF_CHAR.andThen(TreeCounter::new);
    }

    @Override
    public @NonNull Long solve(@NonNull TreeCounter input) {
        return Stream.of(Displacement.of(1, 1),
                         Displacement.of(3, 1),
                         Displacement.of(5, 1),
                         Displacement.of(7, 1),
                         Displacement.of(1, 2))
                     .mapToLong(input::count)
                     .reduce(1, (l1, l2) -> l1 * l2);
    }
}
