package perococco.aoc.day11.structures.algo;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.GridHelper;
import perococco.aoc.common.Position;
import perococco.aoc.day11.structures.AdjacentCounter;
import perococco.aoc.day11.structures.SeatLayout;

@RequiredArgsConstructor
public class AroundAdjacentCounter implements AdjacentCounter {

    private final @NonNull GridHelper gridHelper;

    @Override
    public void updateOccupationMap(@NonNull SeatLayout seatLayout, long[] buffer) {
        assert buffer.length == seatLayout.height()*seatLayout.width();
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = countOccupied(seatLayout,gridHelper.positionFor(i));
        }
    }

    private long countOccupied(@NonNull SeatLayout seatLayout, @NonNull Position center) {
        return gridHelper.allAdjacentPosition(center)
                         .filter(seatLayout::isOccupiedSeat)
                         .count();
    }
}
