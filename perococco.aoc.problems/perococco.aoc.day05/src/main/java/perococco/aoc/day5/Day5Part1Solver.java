package perococco.aoc.day5;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day5.structures.BoardingPass;

import java.util.stream.Stream;

public class Day5Part1Solver extends Day5Solver<Integer> {

    public static @NonNull AOCProblem<?> provider() {
        return new Day5Part1Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull Stream<BoardingPass> input) {
        return input.mapToInt(BoardingPass::getSeatId).max().orElse(-1);
    }
}
