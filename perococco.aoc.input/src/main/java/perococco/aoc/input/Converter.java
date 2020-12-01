package perococco.aoc.input;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.common.AOCException;

import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@FunctionalInterface
public interface Converter<I> extends Function<Stream<String>,I> {

    @NonNull I convert(@NonNull Stream<String> input);

    @Override
    default @NonNull I apply(Stream<String> stringStream) {
        return convert(stringStream);
    }

    @Override
    default <V> Converter<V> andThen(Function<? super I, ? extends V> after) {
        return s -> after.apply(apply(s));
    }

    Converter<IntStream> TO_INT_STREAM = s -> s.mapToInt(Integer::parseInt);
    Converter<String> FIRST_LINE = s -> s.findFirst().orElseThrow(() -> new AOCException("Empty input"));
    Converter<Stream<String>> IDENTITY = s -> s;
    Converter<ImmutableList<String>> ALL_LINES = s -> s.collect(ImmutableList.toImmutableList());
}
