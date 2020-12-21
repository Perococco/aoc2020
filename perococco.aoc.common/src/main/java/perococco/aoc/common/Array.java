package perococco.aoc.common;

import lombok.NonNull;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface Array {

    int width();

    int height();

    @NonNull
    default Stream<Position> positionStream() {
        final int width = width();
        return IntStream.range(0, width*height()).mapToObj(i -> Position.of(i%width, i/width));
    }

}
