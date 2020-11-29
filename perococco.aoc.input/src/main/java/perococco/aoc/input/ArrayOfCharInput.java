package perococco.aoc.input;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.ArrayOfChar;

import java.util.function.Function;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class ArrayOfCharInput implements Input<ArrayOfChar> {

    private final @NonNull ArrayOfChar data;

    @Override
    public @NonNull ArrayOfChar readData() {
        return data;
    }

    public static @NonNull Function<Stream<String>,ArrayOfChar> mapper(char filling) {
        return s -> s.collect(ArrayOfChar.collector(filling));
    }

}
