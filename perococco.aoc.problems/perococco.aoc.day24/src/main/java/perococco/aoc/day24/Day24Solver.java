package perococco.aoc.day24;

import com.google.common.collect.ImmutableSet;
import lombok.NonNull;
import perococco.aoc.day24.structures.HexaPoint;
import perococco.aoc.day24.structures.Path;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public abstract class Day24Solver extends SmartSolver<Stream<Path>,Integer> {

    @Override
    protected @NonNull Converter<Stream<Path>> getConverter() {
        return s -> s.map(Path::parse);
    }

    protected @NonNull ImmutableSet<HexaPoint> initialBlackTiles(@NonNull Stream<Path> paths) {
        final Set<HexaPoint> blackTiles = new HashSet<>();
        final HexaPoint center = new HexaPoint(0,0);

        paths.map(p -> p.pointAtEndOfPath(center))
             .forEach(p -> {
                 if (!blackTiles.remove(p)) {
                     blackTiles.add(p);
                 }
             } );

        return ImmutableSet.copyOf(blackTiles);
    }
}
