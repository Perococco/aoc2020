package perococco.aoc.day11.structures;

import lombok.NonNull;
import perococco.aoc.common.Position;

public interface AdjacentCounter {

    long countOccupied(@NonNull ReadOnlySeatLayout seatLayout, @NonNull Position center);
}
