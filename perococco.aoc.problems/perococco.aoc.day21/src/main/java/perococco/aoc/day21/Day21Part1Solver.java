package perococco.aoc.day21;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day21.structures.Guide;

public class Day21Part1Solver extends Day21Solver<Integer> {

    public static @NonNull AOCProblem<?> provider() {
        return new Day21Part1Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull Guide guide) {

        return guide.safeIngredients()
             .stream()
             .mapToInt(i -> guide.bagOfIngredients().quantity(i))
             .sum();

    }
}
