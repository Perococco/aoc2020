package perococco.aoc.day24;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day24.structures.Color;
import perococco.aoc.day24.structures.HexaPoint;
import perococco.aoc.day24.structures.Path;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Day24Part1Solver extends Day24Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day24Part1Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull Stream<Path> input) {
        return initialBlackTiles(input).size();
    }
}
