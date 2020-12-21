package perococco.aoc.day20;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day20.structures.ImageBuilder;
import perococco.aoc.day20.structures.ImageTile;
import perococco.aoc.day20.structures.Orientation;
import perococco.aoc.day20.structures.OrientedImageTitle;

public class Day20Part1Solver extends Day20Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day20Part1Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull ImmutableList<ImageTile> imageTiles) {
        final var list = ImageBuilder.build(imageTiles);
        return computeProductOfIdOfCorners(list);
    }



}
