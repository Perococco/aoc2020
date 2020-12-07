package perococco.aoc.day7;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.stream.Stream;

import static perococco.aoc.common.Tools.TODO;

public class Day7Part1Solver extends Day7Solver<String> {

    @Override
    public @NonNull String solve(@NonNull Stream<String> input) {
        return TODO();
    }

    public static @NonNull AOCProblem<?> provider() {
        return new Day7Part1Solver().createProblem().skipped();
    }


}
