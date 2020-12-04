package perococco.aoc.day3;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.Displacement;
import perococco.aoc.day3.structures.TreeCounter;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

public class Day3Part1Solver extends SmartSolver<TreeCounter, Long> {

    public static @NonNull AOCProblem<?> provider() {
        return new Day3Part1Solver().createProblem();
    }

    @Override
    protected @NonNull Converter<TreeCounter> getConverter() {
        return Converter.TO_ARRAY_OF_CHAR.andThen(TreeCounter::new);
    }

    @Override
    public @NonNull Long solve(@NonNull TreeCounter input) {
        final var displacement = Displacement.of(3, 1);
        return input.count(displacement);
    }
}
