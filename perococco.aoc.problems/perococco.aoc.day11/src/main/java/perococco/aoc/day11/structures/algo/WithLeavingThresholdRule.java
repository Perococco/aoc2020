package perococco.aoc.day11.structures.algo;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.day11.structures.State;
import perococco.aoc.day11.structures.StateEvolutionRule;

@RequiredArgsConstructor
public class WithLeavingThresholdRule implements StateEvolutionRule {

    private final long occupiedThresholdWhenLeaving;

    @Override
    public @NonNull State evaluateNewSate(@NonNull State current, long numberOfAdjacentOccupiedSeats) {
        return switch (current) {
            case OCCUPIED_SEAT -> numberOfAdjacentOccupiedSeats<occupiedThresholdWhenLeaving?State.OCCUPIED_SEAT:State.EMPTY_SEAT;
            case FLOOR -> State.FLOOR;
            case EMPTY_SEAT -> numberOfAdjacentOccupiedSeats==0?State.OCCUPIED_SEAT:State.EMPTY_SEAT;
        };
    }
}
