package perococco.aoc.common;

import lombok.NonNull;

import java.util.stream.Stream;

public interface GridHelper {

    int width();

    int height();

    @NonNull Stream<Position> allAdjacentPosition(@NonNull Position center);

    @NonNull Stream<Position> allPositionOnGrid();

    int linearIndexFor(@NonNull Position position);

    @NonNull Stream<Position> positionsInDirection(@NonNull Position center, @NonNull Displacement displacement);
}
