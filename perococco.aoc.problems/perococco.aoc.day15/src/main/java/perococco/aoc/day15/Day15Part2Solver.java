package perococco.aoc.day15;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static perococco.aoc.common.Tools.TODO;

public class Day15Part2Solver extends Day15Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day15Part2Solver().createProblem();
    }

    @Override
    protected int getNumberOfTurns() {
        return 30_000_000;
    }
}
