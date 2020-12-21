package perococco.aoc.day20;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.Pattern;
import perococco.aoc.common.Position;
import perococco.aoc.common.Transformation;
import perococco.aoc.day20.structures.ImageArrayBuilder;
import perococco.aoc.day20.structures.ImageTile;

import java.util.HashSet;
import java.util.Set;

public class Day20Part2Solver extends Day20Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day20Part2Solver().createProblem();
    }

    private static final String MONSTER = """
                              #\s
            #    ##    ##    ###
             #  #  #  #  #  #  \s
             """;

    @Override
    public @NonNull Long solve(@NonNull ImmutableList<ImageTile> imageTiles) {
        final var imageArray = ImageArrayBuilder.build(imageTiles);

        final var image = imageArray.buildImage();
        final var monster = new Pattern(MONSTER, '#');


        final long nbMonsters = Transformation.all()
                                              .map(image::transform)
                                              .mapToLong(i -> monster.numberOfMatches(i, '#'))
                                              .filter(l -> l > 0)
                                              .findFirst()
                                              .orElse(-1);

        final long nbSharps = image.positionStream().filter(p -> image.get(p) == '#').count();

        return nbSharps - nbMonsters*monster.nbPoints();
    }

}
