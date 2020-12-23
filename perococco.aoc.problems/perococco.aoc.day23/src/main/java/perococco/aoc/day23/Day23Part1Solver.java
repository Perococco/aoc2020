package perococco.aoc.day23;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;

public class Day23Part1Solver extends Day23Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day23Part1Solver().createProblem();
    }

    @Override
    public @NonNull String solve(@NonNull String input) {
        final var circle = new CupCircle(input);
        circle.performMoves(100);
        return circle.part1Result();
    }
}
