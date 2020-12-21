package perococco.aoc.day20;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.ArrayOfChar;
import perococco.aoc.common.Displacement;
import perococco.aoc.common.Position;
import perococco.aoc.day20.structures.ImageBuilder;
import perococco.aoc.day20.structures.ImageTile;

import java.util.HashSet;
import java.util.Set;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

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
        final var operators = ImmutableList.<UnaryOperator<ArrayOfChar>>of(
                a -> a,
                ArrayOfChar::rotate90,
                ArrayOfChar::rotate90,
                ArrayOfChar::rotate90,
                a -> a.rotate90().flip(),
                ArrayOfChar::rotate90,
                ArrayOfChar::rotate90,
                ArrayOfChar::rotate90
        );

        var positions = parseMonster();
        var image = buildFullImage(imageTiles);
        for (var operator : operators) {
            image = operator.apply(image);
            long numberOfMonsters = countNumberOfMonsters(image, positions);
            if (numberOfMonsters > 0) {
                final var img = image;
                final var nbSharps = image.positionStream().filter(p -> img.get(p) == '#').count();
                return nbSharps - numberOfMonsters*positions.size();
            }
        }

        return -1L;
    }

    private long countNumberOfMonsters(ArrayOfChar image, @NonNull Set<Position> positionToTest) {
        return image.positionStream()
                    .map(p -> Displacement.of(p.x(), p.y()))
                    .filter(d ->
                                    positionToTest.stream()
                                                  .map(p -> p.displaced(d))
                                                  .allMatch(p -> image.get(p) == '#')
                    ).count();
    }

    private Set<Position> parseMonster() {
        final Set<Position> positions = new HashSet<>();
        final String[] lines = MONSTER.split("\n");
        for (int y = 0; y < lines.length; y++) {
            final var line = lines[y];
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '#') {
                    positions.add(Position.of(x, y));
                }
            }
        }
        return positions;
    }

    private ArrayOfChar buildFullImage(@NonNull ImmutableList<ImageTile> imageTiles) {
        final var image = ImageBuilder.build(imageTiles);
        final ImageTile first = imageTiles.get(0);
        final int nbTiles = imageTiles.size();
        final int sqrtTiles = (int) Math.round(Math.sqrt(nbTiles));

        final int tileWidth = first.width();
        final int imageWidth = sqrtTiles * (tileWidth - 2);

        final ArrayOfChar arrayOfChar = new ArrayOfChar(new char[imageWidth * imageWidth], '.', imageWidth, imageWidth);

        for (int i = 0; i < image.size(); i++) {
            final int x = i % sqrtTiles;
            final int y = i / sqrtTiles;
            final var imageTile = image.get(i);

            arrayOfChar.setWith(x * (tileWidth - 2), y * (tileWidth - 2), imageTile.asArrayOfChar(), 1, 1, tileWidth - 2, tileWidth - 2);
        }
        return arrayOfChar;
    }

}
