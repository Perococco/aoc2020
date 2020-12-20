package perococco.aoc.day20;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.stream.Stream;

import static perococco.aoc.common.Tools.TODO;

public class Day20Part1Solver extends Day20Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day20Part1Solver().createProblem().skipped();
    }

    @Override
    public @NonNull Object solve(@NonNull Stream<String> input) {
        return TODO();
    }
}
