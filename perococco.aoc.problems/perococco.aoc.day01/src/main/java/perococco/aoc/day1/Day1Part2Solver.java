package perococco.aoc.day1;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Table;
import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day1Part2Solver extends SmartSolver<IntStream, Long> {

    public static AOCProblem<?> provider() {
        return new Day1Part2Solver().createProblem();
    }

    @Override
    protected @NonNull Converter<IntStream> getConverter() {
        return Converter.TO_INT_STREAM;
    }

    @Override
    public @NonNull Long solve(@NonNull IntStream input) {
        final Context context = new Context();

        return input.mapToLong(i -> compute(i, context)).filter(i -> i > 0).findFirst().orElse(-1);
    }

    private long compute(int value, Context context) {
        if (value <= 0 || value >= 2020) {
            return -1;
        }

        {
            final int complement = 2020 - value;
            if (context.products[complement] > 0) {
                return context.products[complement] * value;
            }
        }

        for (int val : context.seen) {
            final int cp = val+value;
            if (cp<2020) {
                context.products[cp] = val*value;
            }
        }
        context.seen.add(value);

        return -1;
    }

    private static class Context {

        private final @NonNull Set<Integer> seen = new HashSet<>();
        private final @NonNull long[] products = new long[2020];

        public Context() {
            Arrays.fill(products,-1);
        }
    }
}
