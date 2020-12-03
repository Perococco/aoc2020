package perococco.aoc.common;

import lombok.Value;

@Value
public class Displacement {

    int dx;

    int dy;

    public static Displacement of(int dx, int dy) {
        return new Displacement(dx,dy);
    }

}
