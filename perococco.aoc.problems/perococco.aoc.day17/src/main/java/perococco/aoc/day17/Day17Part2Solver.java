package perococco.aoc.day17;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.ArrayOfChar;
import perococco.aoc.common.GameOfLife;

public class Day17Part2Solver extends Day17Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day17Part2Solver().createProblem();
    }

    @Override
    protected GameOfLife<?> createGameOfLife(@NonNull ArrayOfChar input) {
        return GameOfLife.initialize(input, (x,y) -> Point4D.of(x,y,0,0));
    }
}
