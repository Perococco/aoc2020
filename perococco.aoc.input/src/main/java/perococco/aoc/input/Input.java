package perococco.aoc.input;

import lombok.NonNull;

import java.util.function.Function;
import java.util.stream.Stream;

public interface Input<D> {

    @NonNull
    D readData();

    default <I> @NonNull Input<I> map(@NonNull Function<? super D, ? extends I> mapper) {
        return () -> mapper.apply(readData());
    }

}
