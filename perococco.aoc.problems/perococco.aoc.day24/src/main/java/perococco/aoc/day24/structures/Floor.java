package perococco.aoc.day24.structures;

import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

public class Floor {

    private final Set<HexaPoint> blackTiles;

    public Floor(ImmutableSet<HexaPoint> initialBlackTiles) {
        this.blackTiles = new HashSet<>(initialBlackTiles);
    }
}
