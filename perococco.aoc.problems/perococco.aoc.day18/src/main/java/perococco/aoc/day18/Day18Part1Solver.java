package perococco.aoc.day18;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.Tools;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.stream.Stream;

import static perococco.aoc.common.Tools.*;

public class Day18Part1Solver extends Day18Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day18Part1Solver().createProblem().skipped();
    }


    @Override
    public @NonNull Object solve(@NonNull Stream<String> input) {
        return TODO();
    }
}
