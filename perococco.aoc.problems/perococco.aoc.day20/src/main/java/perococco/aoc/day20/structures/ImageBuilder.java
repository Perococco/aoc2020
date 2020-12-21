package perococco.aoc.day20.structures;

import com.google.common.collect.ImmutableList;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.AOCException;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageBuilder {

    public static @NonNull ImmutableList<OrientedImageTitle> build(@NonNull ImmutableList<ImageTile> tiles) {
        return new ImageBuilder(tiles).build();
    }

    private final ImmutableList<ImageTile> tiles;
    private int width;
    private Dictionary dictionary;

    private @NonNull ImmutableList<OrientedImageTitle> build() {
        this.buildTileDictionary();
        this.computeFinalImageSize();

        final var image = ImageInProgress.initial(width);
        final Set<Integer> availableIds = tiles.stream().map(ImageTile::id).collect(Collectors.toSet());

        return addNewPiece(image, availableIds).orElseThrow(() -> new AOCException("I'm too stupid to solve this"));

    }

    private void computeFinalImageSize() {
        this.width = (int) Math.round(Math.sqrt(tiles.size()));
    }

    private void buildTileDictionary() {
        this.dictionary = DictionaryBuilder.build(tiles);
    }

    private @NonNull Optional<ImmutableList<OrientedImageTitle>> addNewPiece(@NonNull ImageInProgress image, @NonNull final Set<Integer> availableIds) {
        if (availableIds.isEmpty()) {
            return Optional.of(image.buildResult());
        }

        final Stream<OrientedImageTitle> matchingTiles;
        if (image.x == 0 && image.y == 0) {
            matchingTiles = dictionary.allTiles();
        } else if (image.x == 0) {
            matchingTiles = dictionary.findWithUpMatching(image.getMatchingDown());
        } else if (image.y == 0) {
            matchingTiles = dictionary.findWithLeftMatching(image.getMatchingRight());
        } else {
            matchingTiles = dictionary.findWithLeftAndUpMatching(image.getMatchingRight(), image.getMatchingDown());
        }

        final Predicate<OrientedImageTitle> isAvailable = i -> availableIds.contains(i.getImageTileId());
        final var candidates = matchingTiles.filter(isAvailable).collect(Collectors.toSet());

        while (true) {
            final OrientedImageTitle tested = candidates.stream().findAny().orElse(null);
            if (tested == null) {
                break;
            }
            candidates.remove(tested);
            availableIds.remove(tested.getImageTileId());
            image.pushTile(tested);
            final var result = addNewPiece(image, availableIds);
            if (result.isPresent()) {
                return result;
            }
            image.popTile();
            availableIds.add(tested.getImageTileId());
        }
        return Optional.empty();
    }

    @AllArgsConstructor
    private static class ImageInProgress {

        private final List<OrientedImageTitle> matchingTiles;
        private final int width;
        private int x;
        private int y;

        public static @NonNull ImageInProgress initial(int width) {
            return new ImageInProgress(new ArrayList<>(width*width),width, 0, 0);
        }

        public @NonNull String getMatchingDown() {
            return getImageAt(x, y - 1).matchingDown();
        }

        public @NonNull String getMatchingRight() {
            return getImageAt(x - 1, y).matchingRight();
        }

        public @NonNull OrientedImageTitle getImageAt(int x, int y) {
            return matchingTiles.get(x + y * width);
        }

        public void pushTile(@NonNull OrientedImageTitle tested) {
            matchingTiles.add(tested);
            this.moveToNextPosition();
        }

        public void popTile() {
            matchingTiles.remove(matchingTiles.size() - 1);
            moveBackToPreviousPosition();
        }

        private void moveBackToPreviousPosition() {
            x = x - 1;
            if (x < 0) {
                y = y - 1;
                x += width;
            }
        }

        private void moveToNextPosition() {
            x = x + 1;
            if (x >= width) {
                y = y + 1;
                x -= width;
            }
        }

        public @NonNull ImmutableList<OrientedImageTitle> buildResult() {
            return ImmutableList.copyOf(matchingTiles);
        }
    }
}
