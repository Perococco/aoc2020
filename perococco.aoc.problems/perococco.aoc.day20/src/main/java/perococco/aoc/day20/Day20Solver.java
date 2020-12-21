package perococco.aoc.day20;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.day20.structures.ImageTile;
import perococco.aoc.day20.structures.OrientedImageTitle;
import perococco.aoc.day20.structures.Parser;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day20Solver extends SmartSolver<ImmutableList<ImageTile>,Long> {

    @Override
    protected @NonNull Converter<ImmutableList<ImageTile>> getConverter() {
        return Converter.ALL_LINES.andThen(Parser::parse);
    }

    public long computeProductOfIdOfCorners(@NonNull ImmutableList<OrientedImageTitle> image) {
        int width = (int)Math.round(Math.sqrt(image.size()));

        final var c1 = image.get(0);
        final var c2 = image.get(width-1);
        final var c4=image.get(width*width-1);
        final var c3=image.get((width-1)*width);

        return Stream.of(c1,c2,c3,c4).mapToLong(c -> c.getImageTileId()).reduce(1, (i1,i2) -> i1*i2);

    }
}
