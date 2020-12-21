package perococco.aoc.common;

import lombok.NonNull;

import java.io.PrintStream;

public class GenericArray<T> extends BaseArray {

    private final @NonNull T[] data;

    public GenericArray(@NonNull T[] data, int width, int height) {
        super(width, height);
        this.data = data;
    }

    public @NonNull T get(@NonNull Position position) {
        return get(position.x(),position.y());
    }

    public @NonNull T get(int x, int y) {
        if (isInRange(x,y)) {
            return data[xyToIndex(x,y)];
        }
        throw new IndexOutOfBoundsException("x="+x+" y="+y+"  width="+width()+" height="+height());
    }


    @Override
    protected void printSingleElement(@NonNull PrintStream printStream, int elementIndex) {
        printStream.println(data[elementIndex]);
    }
}
