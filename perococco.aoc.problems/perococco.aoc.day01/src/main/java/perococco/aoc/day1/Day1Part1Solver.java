package perococco.aoc.day1;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.AOCException;

import java.util.Optional;

public class Day1Part1Solver extends Day1Solver<Integer> {

    public static AOCProblem<?> provider() {
        return new Day1Part1Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull int[] input) {
        final var finder = new ProductFinder();

        for (int value : input) {
            final Optional<Integer> product = finder.onNewValue(value);
            if (product.isPresent()) {
                return product.get();
            }
        }
        throw new AOCException("Cannot find 2 numbers that sum to 2020");
    }

    private static class ProductFinder {

        private final boolean[] seen = new boolean[2021];

        public @NonNull Optional<Integer> onNewValue(int value) {
            if (value<0 || value>2020) {
                return Optional.empty();
            }

            final int complement = 2020-value;
            if (seen[complement]) {
                return Optional.of(complement * value);
            }

            seen[value] = true;
            return Optional.empty();
        }
    }
}
