package perococco.aoc.day11.structures;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.GridHelper;
import perococco.aoc.common.Position;

@RequiredArgsConstructor
public class AroundAdjacentCounter implements AdjacentCounter {

    private final @NonNull GridHelper gridHelper;

    @Override
    public long countOccupied(@NonNull ReadOnlySeatLayout seatLayout, @NonNull Position center) {
        return gridHelper.allAdjacentPosition(center)
                         .filter(seatLayout::isOccupiedSeat)
                         .count();
    }
}
