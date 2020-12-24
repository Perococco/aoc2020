package perococco.aoc.common;

import lombok.NonNull;

import java.util.stream.Stream;

public interface NeighbourProvider<P> {

    @NonNull Stream<P> neighbours();
}
