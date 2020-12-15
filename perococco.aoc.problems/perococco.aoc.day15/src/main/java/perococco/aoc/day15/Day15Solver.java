package perococco.aoc.day15;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class Day15Solver extends SmartSolver<long[],Long> {

    @Override
    protected @NonNull Converter<long[]> getConverter() {
        return Converter.FIRST_LINE.andThen(this::toArrayOfNumbers);
    }

    private long[] toArrayOfNumbers(@NonNull String line) {
        return Arrays.stream(line.split(","))
                     .mapToLong(Long::parseLong)
                     .toArray();
    }

    protected abstract int getNumberOfTurns();

    public Long solve(long[] input) {
        return Execution.getSpokenAtLastTurn(input,getNumberOfTurns());
    }

    @RequiredArgsConstructor
    private static class Execution {

        public static long getSpokenAtLastTurn(@NonNull long[] initialNumbers, int numberOfTurns) {
            return new Execution(initialNumbers,numberOfTurns).getSpokenAtLastTurn();
        }

        private final @NonNull long[] initialNumbers;

        private final int numberOfTurns;

        private final Map<Long,NumberHistory> historyMap = new HashMap<>();

        public long getSpokenAtLastTurn() {
            this.initializeHistoryMap();
            long lastSpoken = initialNumbers[initialNumbers.length-1];
            for (int turn = initialNumbers.length; turn < numberOfTurns; turn++) {
                final var nextToSay = historyMap.get(lastSpoken).getNextToSay();
                this.updateNumberHistory(nextToSay,turn);
                lastSpoken = nextToSay;
            }
            return lastSpoken;
        }

        private void initializeHistoryMap() {
            for (int turn = 0; turn < initialNumbers.length; turn++) {
                historyMap.put(initialNumbers[turn],new NumberHistory(initialNumbers[turn],turn));
            }
        }


        private void updateNumberHistory(final long number, final int turn) {
            historyMap.computeIfAbsent(number,l -> new NumberHistory(number,turn)).setLastSpokenTurn(turn);
        }


    }
}
