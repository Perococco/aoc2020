package perococco.aoc.day6;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day6.structures.Group;

public class Day6Part2Solver extends Day6Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day6Part2Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull ImmutableList<Group> input) {
        return input.stream()
                    .mapToInt(Group::getNumberOfCommonQuestions)
                    .sum();
    }
}
