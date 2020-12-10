package perococco.aoc.day10;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.Tools;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

import static perococco.aoc.common.Tools.TODO;

public class Day10Part1Solver extends Day10Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day10Part1Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(int @NonNull [] input) {
        Arrays.sort(input);
        final var counter = new Counter();

        counter.updateWith(0,input[0]);
        for (int i = 1; i < input.length; i++) {
            counter.updateWith(input[i-1], input[i]);
        }
        counter.handleBuiltInJoltageAdapter();
        return (long)counter.getResult();
    }

    private static class Counter {
        private int nbStep1 = 0;
        private int nbStep3 = 0;

        public void updateWith(int nb1, int nb2) {
            final int dif = nb2 - nb1;
            if (dif == 1) {
                nbStep1++;
            } else if (dif == 3) {
                nbStep3++;
            }
        }

        public void handleBuiltInJoltageAdapter() {
            nbStep3++;
        }

        public int getResult() {
            return nbStep1*nbStep3;
        }

    }
}
