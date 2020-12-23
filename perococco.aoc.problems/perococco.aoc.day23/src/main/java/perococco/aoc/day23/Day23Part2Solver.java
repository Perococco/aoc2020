package perococco.aoc.day23;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;

public class Day23Part2Solver extends Day23Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day23Part2Solver().createProblem();
    }

    @Override
    public @NonNull String solve(@NonNull String input) {
        final var circle = new CupCircle(input, 1_000_000);
        circle.performMoves(10_000_000);
        return circle.part2Result();
    }
}
