package perococco.aoc.common;

import lombok.Value;

@Value
public class Position {

    int x;

    int y;

    public static Position of(int x, int y) {
        return new Position(x,y);
    }

    @Override
    public String toString() {
        return "(x=" + x + ", y=" + y + ")";
    }
}
