package perococco.aoc.day20;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day20.structures.ImageBuilder;
import perococco.aoc.day20.structures.ImageTile;
import perococco.aoc.day20.structures.Orientation;
import perococco.aoc.day20.structures.OrientedImageTitle;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day20Part1Solver extends Day20Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day20Part1Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull ImmutableList<ImageTile> imageTiles) {
        final var list = ImageBuilder.build(imageTiles);
        return computeProductOfIdOfCorners(list);
    }

    public long computeProductOfIdOfCorners(@NonNull ImmutableList<OrientedImageTitle> images) {
        int width = (int) Math.round(Math.sqrt(images.size()));

        return IntStream.of(0, width - 1, width * width - width, width * width - 1)
                        .mapToObj(images::get)
                        .mapToLong(OrientedImageTitle::getImageTileId)
                        .reduce(1, (i1, i2) -> i1 * i2);

    }

}
