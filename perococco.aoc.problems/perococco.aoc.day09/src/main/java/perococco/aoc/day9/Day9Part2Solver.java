package perococco.aoc.day9;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.api.AOCProblem;

import java.util.stream.IntStream;

@RequiredArgsConstructor
public class Day9Part2Solver extends Day9Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day9Part2Solver(25).createProblem();
    }

    private final int preambleSize;

    @Override
    public Long solve(long[] input) {
        final long target = new Day9Part1Solver(preambleSize).solve(input);
        return new Context(input,target).findMinMaxSum();
    }

    private static class Context {

        private final long[] input;

        private final long target;

        private int idxInf;

        private int idxSup;

        private long sum;

        public Context(long[] input, long target) {
            this.input = input;
            this.target = target;
            this.idxInf = 0;
            this.idxSup = 1;
            this.sum = input[idxInf]+input[idxSup];
        }

        public long findMinMaxSum() {
            while(performOneStep());
            final var statistic =  IntStream.rangeClosed(idxInf,idxSup).mapToLong(i -> input[i]).summaryStatistics();
            return statistic.getMin()+statistic.getMax();
        }

        /**
         * @return true if the search should continue
         */
        private boolean performOneStep() {
            if (sum == target) {
                return false;
            }
            else if (sum<target) {
                idxSup++;
                sum+=input[idxSup];
            }
            else {
                sum-=input[idxInf];
                idxInf++;
            }
            return true;
        }


    }
}
