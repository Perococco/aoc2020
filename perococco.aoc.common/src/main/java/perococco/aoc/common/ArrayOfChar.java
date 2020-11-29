package perococco.aoc.common;

import lombok.NonNull;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collector;
import java.util.stream.IntStream;

/**
 * @author perococco
 **/
public class ArrayOfChar extends BaseArray {

    @NonNull
    private final char[] data;

    private final char filling;

    public ArrayOfChar(@NonNull char[] data, char filling, int width, int height) {
        super(width, height);
        this.data = data;
        this.filling = filling;
    }

    public char get(@NonNull Position position) {
        if (isPositionInRange(position)) {
            return data[positionToIndex(position)];
        }
        return filling;
    }

    @Override
    protected void printSingleElement(@NonNull PrintStream printStream, int elementIndex) {
        printStream.print(data[elementIndex]);
    }

    @NonNull
    public <T> T[] convert(@NonNull Function<? super Character, ? extends T> converter,@NonNull IntFunction<T[]> arrayCreator) {
        return IntStream.range(0,width()*height()).mapToObj(i -> converter.apply(data[i])).toArray(arrayCreator);
    }

    @NonNull
    public static Collector<String,?,ArrayOfChar> collector(char filling) {
        return baseCollector(
                String::toCharArray,
                c -> c.length,
                char[]::new,
                a -> Arrays.fill(a, filling),
                (source, destination, destinationOffset) -> System.arraycopy(source, 0, destination, destinationOffset,
                                                                             source.length),
                (source, width, height) -> new ArrayOfChar(source,filling,width,height)


        );
    }
}
