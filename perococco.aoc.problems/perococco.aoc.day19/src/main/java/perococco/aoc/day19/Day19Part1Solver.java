package perococco.aoc.day19;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day19.structures.BasicMatcher;
import perococco.aoc.day19.structures.Day19Input;
import perococco.aoc.day19.structures.Rule;

import java.util.function.Predicate;

public class Day19Part1Solver extends Day19Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day19Part1Solver().createProblem();
    }

    @Override
    protected @NonNull Day19Input modifyInput(@NonNull Day19Input input) {
        return input;
    }
}
