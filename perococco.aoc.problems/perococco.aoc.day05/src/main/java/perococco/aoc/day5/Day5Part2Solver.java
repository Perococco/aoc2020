package perococco.aoc.day5;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.Tools;
import perococco.aoc.day5.structures.BoardingPass;

import java.util.stream.Stream;

public class Day5Part2Solver extends Day5Solver<Long> {

    public static @NonNull AOCProblem<?> provider() {
        return new Day5Part2Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull Stream<BoardingPass> input) {
        final var statistic = input.mapToInt(BoardingPass::getSeatId)
                                   .summaryStatistics();
        final var sumFromMinToMax = Tools.sumUpTo(statistic.getMax()) - Tools.sumUpTo(statistic.getMin() - 1);
        final var missingId = sumFromMinToMax - statistic.getSum();

        return missingId;
    }
}
