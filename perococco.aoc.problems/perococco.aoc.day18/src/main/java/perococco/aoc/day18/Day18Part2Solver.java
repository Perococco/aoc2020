package perococco.aoc.day18;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.stream.Stream;

import static perococco.aoc.common.Tools.TODO;

public class Day18Part2Solver extends Day18Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day18Part2Solver().createProblem().skipped();
    }

    @Override
    public @NonNull Object solve(@NonNull Stream<String> input) {
        return TODO();
    }
}
