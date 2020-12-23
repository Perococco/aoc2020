package perococco.aoc.day21;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day21.structures.Guide;
import perococco.aoc.day21.structures.Ingredient;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Day21Part2Solver extends Day21Solver<String> {

    public static @NonNull AOCProblem<?> provider() {
        return new Day21Part2Solver().createProblem();
    }

    @Override
    public @NonNull String solve(@NonNull Guide guide) {
        return guide.allergenIdentification()
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparing(Map.Entry::getKey))
                    .map(Map.Entry::getValue)
                    .map(Ingredient::name)
                    .collect(Collectors.joining(","));
    }
}
