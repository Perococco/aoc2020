package perococco.aoc.day20;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.Tools;
import perococco.aoc.day20.structures.ImageArrayBuilder;
import perococco.aoc.day20.structures.ImageTile;

public class Day20Part1Solver extends Day20Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day20Part1Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull ImmutableList<ImageTile> imageTiles) {
        final var imageArray = ImageArrayBuilder.build(imageTiles);

        return imageArray.corners()
                         .mapToLong(ImageTile::id)
                         .reduce(1, Tools::longProduct);
    }

}
