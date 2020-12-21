package perococco.aoc.day15;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;

public class Day15Part2Solver extends Day15Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day15Part2Solver().createProblem();
    }

    @Override
    protected int getNumberOfTurns() {
        return 30_000_000;
    }
}
