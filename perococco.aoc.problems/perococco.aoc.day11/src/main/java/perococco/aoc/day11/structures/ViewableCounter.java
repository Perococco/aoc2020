package perococco.aoc.day11.structures;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.Displacement;
import perococco.aoc.common.GridHelper;
import perococco.aoc.common.Position;

import java.util.stream.Stream;

@RequiredArgsConstructor
public class ViewableCounter implements AdjacentCounter {

    private final @NonNull GridHelper gridHelper;

    @Override
    public long countOccupied(@NonNull ReadOnlySeatLayout seatLayout, @NonNull Position center) {
        return Stream.of(Displacement.N,
                         Displacement.E,
                         Displacement.S,
                         Displacement.W,
                         Displacement.NE,
                         Displacement.NW,
                         Displacement.SE,
                         Displacement.SW)
              .filter(displacement -> isOccupied(seatLayout,center,displacement))
              .count();
    }

    private boolean isOccupied(@NonNull ReadOnlySeatLayout seatLayout, @NonNull Position center, @NonNull Displacement displacement) {
        final var visibleState = gridHelper.positionsInDirection(center, displacement)
                                           .map(seatLayout::stateAt)
                                           .filter(s -> s != State.FLOOR)
                                           .findFirst()
                                           .orElse(State.FLOOR);
        return visibleState == State.OCCUPIED_SEAT;
    }

}
