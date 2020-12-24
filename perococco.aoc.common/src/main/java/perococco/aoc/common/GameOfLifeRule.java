package perococco.aoc.common;

import lombok.NonNull;

public interface GameOfLifeRule {

    @NonNull CellState newState(@NonNull CellState previousState, int nbNeighbour);

    GameOfLifeRule DEFAULT_RULE = (current,neighbour) -> {
        if (neighbour == 3) {
            return CellState.ALIVE;
        } else if (neighbour == 2) {
            return current;
        }
        return CellState.DEAD;
    };

}
