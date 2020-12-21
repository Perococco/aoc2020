package perococco.aoc.day1;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.AOCException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Day1Part2Solver extends Day1Solver<Long> {

    public static AOCProblem<?> provider() {
        return new Day1Part2Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull int[] input) {
        final ProductFinder productFinder = new ProductFinder();
        for (int value : input) {
            final var solution = productFinder.onNewValue(value);
            if (solution.isPresent()) {
                return solution.get();
            }
        }
        throw new AOCException("Cannot find 3 values that sum to 2020");
    }

    private static class ProductFinder {

        private final @NonNull Set<Integer> seen = new HashSet<>();
        private final @NonNull int[] products = new int[2020];

        public ProductFinder() {
            Arrays.fill(products, -1);
        }

        public @NonNull Optional<Long> onNewValue(int value) {
            if (isAnInvalidValue(value)) {
                return Optional.empty();
            }
            final var solution = findSolutionWithAlreadySeenValues(value);
            if (solution.isPresent()) {
                return solution;
            }
            this.updateComplementProducts(value);
            seen.add(value);
            return Optional.empty();
        }

        private boolean isAnInvalidValue(int value) {
            return value < 0 || value > 2020;
        }

        private @NonNull Optional<Long> findSolutionWithAlreadySeenValues(int value) {
            return Optional.of(products[2020 - value])
                           .filter(p -> p >= 0)
                           .map(p -> p * (long)value);
        }

        private void updateComplementProducts(int value) {
            for (int val : seen) {
                final int complement = val + value;
                if (complement < 2020) {
                    products[complement] = val * value;
                }
            }
        }


    }
}
