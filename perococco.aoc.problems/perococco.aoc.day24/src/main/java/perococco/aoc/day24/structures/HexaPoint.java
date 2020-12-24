package perococco.aoc.day24.structures;

import lombok.NonNull;
import lombok.Value;
import perococco.aoc.common.NeighbourProvider;

import java.util.stream.Stream;

@Value
public class HexaPoint implements NeighbourProvider<HexaPoint> {

    int x;
    int y;

    public @NonNull MutableHexaPoint toMutable() {
        return new MutableHexaPoint(x,y);
    }

    public @NonNull HexaPoint neighbour(@NonNull Direction direction) {
        return switch (direction) {
            case E -> new HexaPoint(x+2,y);
            case NE -> new HexaPoint(x+1,y+1);
            case NW -> new HexaPoint(x-1,y+1);
            case W -> new HexaPoint(x-2,y);
            case SW -> new HexaPoint(x-1,y-1);
            case SE -> new HexaPoint(x+1,y-1);
        };
    }

    @Override
    public @NonNull Stream<HexaPoint> neighbours() {
        return Direction.all().map(this::neighbour);
    }
}
