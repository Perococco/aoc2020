package perococco.aoc.day24;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.CellState;
import perococco.aoc.common.GameOfLife;
import perococco.aoc.day24.structures.Path;

import java.util.stream.Stream;

public class Day24Part2Solver extends Day24Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day24Part2Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull Stream<Path> input) {
        final var gameOfLife = GameOfLife.initialize(initialBlackTiles(input), this::rule);

        gameOfLife.performCycles(100);
        return Math.toIntExact(gameOfLife.numberOfActiveCells());
    }

    private @NonNull CellState rule(@NonNull CellState previous, int nbNeighbour) {
        if (previous == CellState.ALIVE) {
            //black
            if (nbNeighbour == 0 || nbNeighbour>2) {
                return CellState.DEAD;
            }
            return CellState.ALIVE;
        }
        else if (previous == CellState.DEAD && nbNeighbour == 2) {
            return CellState.ALIVE;
        }
        return previous;
    }
}
