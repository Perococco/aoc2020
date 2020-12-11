package perococco.aoc.day11.structures;

import lombok.NonNull;
import perococco.aoc.common.Position;

public interface ReadOnlySeatLayout {

    int width();
    int height();

    @NonNull State stateAt(@NonNull Position position);
    @NonNull boolean isFloorAt(@NonNull Position position);
    @NonNull boolean isEmptySeat(@NonNull Position position);
    @NonNull boolean isOccupiedSeat(@NonNull Position position);

    default @NonNull boolean isNotFloor(@NonNull Position position) {
        return !isFloorAt(position);
    }

    long totalNumberOfOccupiedSeats();



}
