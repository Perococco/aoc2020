package perococco.aoc.day24.structures;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import lombok.NonNull;

import java.util.stream.Stream;

public enum Direction {
    E,
    SE,
    SW,
    W,
    NW,
    NE,
    ;

    public static @NonNull Stream<Direction> all() {
        return Holder.ALL.stream();
    }

    private static class Holder {

        private static final ImmutableSet<Direction> ALL = ImmutableSet.copyOf(Direction.values());
    }
}
