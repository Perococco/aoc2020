package perococco.aoc.day20.structures;

import com.google.common.collect.ImmutableSet;
import lombok.NonNull;
import perococco.aoc.common.Position;

import java.util.stream.Stream;

public class Pattern {

    private final @NonNull ImmutableSet<Position> positionsOfSharp;

    public Pattern(@NonNull String pattern) {
        final ImmutableSet.Builder<Position> positions = ImmutableSet.builder();
        final String[] lines = pattern.split("\n");
        for (int y = 0; y < lines.length; y++) {
            final var line = lines[y];
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '#') {
                    positions.add(Position.of(x, y));
                }
            }
        }
        this.positionsOfSharp = positions.build();
    }

    public @NonNull Stream<Position> positionsOfSharp() {
        return positionsOfSharp.stream();
    }
}
