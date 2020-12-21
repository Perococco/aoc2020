package perococco.aoc.common;

public enum Rotation {
    _000,
    _090,
    _180,
    _270,
    ;

    public int getX(int x, int y) {
        return switch (this) {
            case _000 -> x;
            case _090 -> y;
            case _180 -> -1-x;
            case _270 -> -1-y;
        };
    }

    public int getY(int x, int y) {
        return switch (this) {
            case _000 -> y;
            case _090 -> -1-x;
            case _180 -> -1-y;
            case _270 -> x;
        };
    }
}
