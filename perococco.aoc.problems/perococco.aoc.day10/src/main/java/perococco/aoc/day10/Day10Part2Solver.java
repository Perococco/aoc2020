package perococco.aoc.day10;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Day10Part2Solver extends Day10Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day10Part2Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(int @NonNull [] input) {
        return new Counter(input).countArrangements();
    }

    private static class Counter {

        private final int[] sortedPlug;

        private final Map<Integer,Long> cache = new HashMap<>();

        public Counter(int[] input) {
            this.sortedPlug = input.clone();
            Arrays.sort(sortedPlug);
        }

        public long countArrangements() {
            return countArrangements(0,0);
        }

        private long countArrangements(int reference, int fromIndex) {
            final Long cached = cache.get(fromIndex);
            if (cached == null) {
                return countArrangementsWithoutCache(reference,fromIndex);
            } else {
                return cached;
            }
        }

        private long countArrangementsWithoutCache(int reference, int fromIndex) {
            if (fromIndex == sortedPlug.length) {
                return 1;
            }
            long count = 0;
            for (int j = fromIndex; j < sortedPlug.length ; j++) {
                final int dif = sortedPlug[j] - reference;
                if (dif<=3) {
                    count+=countArrangements(sortedPlug[j],j+1);
                }
            }
            cache.put(fromIndex,count);
            return count;
        }

    }
}




