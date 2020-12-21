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

    public char get(int x, int y) {
        if (isInRange(x,y)) {
            return data[xyToIndex(x,y)];
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

    public void set(int x, int y, char value) {
        this.data[xyToIndex(x,y)] = value;
    }

    public void setWith(int destX, int destY, @NonNull ArrayOfChar other, int srcX, int srcY, int lengthX, int lengthY) {
        for (int x = 0,dx=destX,sx=srcX; x < lengthX; x++,dx++,sx++) {
            for (int y = 0,dy=destY,sy=srcY; y < lengthY; y++,dy++,sy++) {
                this.data[xyToIndex(dx,dy)] = other.get(sx,sy);
            }
        }
    }

    public ArrayOfChar flip() {
        final ArrayOfChar flipped = new ArrayOfChar(data.clone(),filling,width(),height());
        for (int x = 0; x < flipped.width() ; x++) {
            for (int y = 0; y < flipped.height(); y++) {
                flipped.data[xyToIndex(x,y)] = this.get(width()-1-x,y);
            }
        }
        return flipped;
    }

    public ArrayOfChar rotate90() {
        final ArrayOfChar rotated = new ArrayOfChar(data.clone(),filling,height(),width());
        for (int x = 0; x < rotated.width() ; x++) {
            for (int y = 0; y < rotated.height(); y++) {
                rotated.data[xyToIndex(x,y)] = this.get(rotated.height()-1-y, x);
            }
        }
        return rotated;
    }

}
