package perococco.aoc.day3;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.ArrayOfChar;
import perococco.aoc.common.Displacement;
import perococco.aoc.common.Position;

import java.util.stream.Stream;

@RequiredArgsConstructor
public class TreeCounter {

    private final @NonNull ArrayOfChar map;

    public long count(@NonNull Displacement displacement) {

        return Stream.iterate(Position.of(0, 0), p -> p.displaced(displacement))
                     .takeWhile(this::isPositionStillOnTheMap)
                     .map(this::wrapPositionOnMap)
                     .filter(this::isThereATreeAtThisPosition)
                     .count();
    }

    private boolean isPositionStillOnTheMap(@NonNull Position position) {
        return position.y() < map.height();
    }

    private Position wrapPositionOnMap(@NonNull Position position) {
        return position.wrap(map.width(), map.height());
    }

    private boolean isThereATreeAtThisPosition(@NonNull Position position) {
        return map.get(position) == '#';
    }
}
