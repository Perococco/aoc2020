package perococco.aoc.day19;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day19.structures.Day19Input;
import perococco.aoc.day19.structures.Or;

import java.util.Map;

import static perococco.aoc.day19.structures.Concatenation.concatenation;
import static perococco.aoc.day19.structures.Or.or;

public class Day19Part2Solver extends Day19Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day19Part2Solver().createProblem();
    }

    @Override
    protected @NonNull Day19Input modifyInput(@NonNull Day19Input input) {
        final Or newRule8 = or(concatenation(42), concatenation(42, 8));
        final Or newRule11 = or(concatenation(42, 31), concatenation(42, 11, 31));
        return input.replaceRules(Map.of(8,newRule8,11,newRule11));
    }
}
