package perococco.aoc.day20;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.Tools;
import perococco.aoc.day20.structures.ImageArray;
import perococco.aoc.day20.structures.ImageTile;

public class Day20Part1Solver extends Day20Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day20Part1Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull ImageArray imageArray) {
        return imageArray.corners()
                         .mapToLong(ImageTile::id)
                         .reduce(1, Tools::longProduct);
    }

}
