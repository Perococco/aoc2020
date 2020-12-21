package perococco.aoc.day20.structures;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.AOCException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageBuilder {

    public static @NonNull ImmutableList<OrientedImageTitle> build(@NonNull ImmutableList<ImageTile> tiles) {
        return new ImageBuilder(tiles).build();
    }

    private final ImmutableList<ImageTile> tiles;
    private int width;
    private Table<String, String, Set<OrientedImageTitle>> dictionary;

    private @NonNull ImmutableList<OrientedImageTitle> build() {
        this.buildTileDictionary();
        this.computeFinalImageSize();

        var image = new ImageInProgress(0,0,new ArrayList<>(tiles.size()));
        Set<Integer> availableIds = tiles.stream().map(ImageTile::id).collect(Collectors.toSet());

        return addNewPiece(image,availableIds).orElseThrow(() -> new AOCException("I'm too stupid to solve this"));

    }

    private void computeFinalImageSize() {
        this.width = (int) Math.round(Math.sqrt(tiles.size()));
    }

    private void buildTileDictionary() {
        this.dictionary = DictionaryBuilder.build(tiles);
    }

    private @NonNull Optional<ImmutableList<OrientedImageTitle>> addNewPiece(@NonNull ImageInProgress image, @NonNull Set<Integer> availableIds) {
        if (availableIds.isEmpty()) {
            return Optional.of(image.buildResult());
        }

        final Stream<OrientedImageTitle> imagesThatMatch;
        if (image.x == 0 && image.y == 0) {
            imagesThatMatch = dictionary.values().stream().flatMap(Collection::stream);
        }
        else if (image.x == 0) {
            final String up = image.getMatchingDown();
            final var elements = dictionary.column(up);
            if (elements == null) {
                imagesThatMatch = Stream.empty();
            } else {
                imagesThatMatch = dictionary.column(up)
                                            .values()
                                            .stream()
                                            .flatMap(Collection::stream);
            }
        }
        else if (image.y == 0) {
            final String right = image.getMatchingRight();
            final var elements = dictionary.row(right);
            if (elements == null) {
                imagesThatMatch = Stream.empty();
            } else {
                imagesThatMatch = dictionary.row(right)
                                          .values()
                                          .stream()
                                          .flatMap(Collection::stream);
            }
        }
        else {
            final String up = image.getMatchingDown();
            final String right = image.getMatchingRight();
            imagesThatMatch = Optional.ofNullable(dictionary.get(right, up))
                                      .stream()
                                      .flatMap(Collection::stream);

        }

        final Set<OrientedImageTitle> candidates = imagesThatMatch.filter(i -> availableIds.contains(i.getImageTileId()))
                .collect(Collectors.toSet());

        while (true) {
            final OrientedImageTitle tested = candidates.stream().findAny().orElse(null);
            if (tested == null) {
                break;
            }
            candidates.remove(tested);
            availableIds.remove(tested.getImageTileId());
            image.pushTile(tested);
            final var result = addNewPiece(image,availableIds);
            if (result.isPresent()) {
                return result;
            }
            image.popTile();
            availableIds.add(tested.getImageTileId());
        }
        return Optional.empty();
    }

    @AllArgsConstructor
    private class ImageInProgress {

        private int x;
        private int y;
        private List<OrientedImageTitle> fitImages;

        public @NonNull String getMatchingDown() {
            return getImageAt(x, y - 1).matchingDown;
        }

        public @NonNull String getMatchingRight() {
            return getImageAt(x - 1, y).matchingRight;
        }

        public OrientedImageTitle getImageAt(int x, int y) {
            return fitImages.get(x + y * width);
        }

        public void pushTile(OrientedImageTitle tested) {
            fitImages.add(tested);
            x = x+1;
            if (x>=width) {
                y=y+1;
                x-=width;
            }
        }

        public void popTile() {
            fitImages.remove(fitImages.size()-1);
            x = x-1;
            if (x<0) {
                y=y-1;
                x+=width;
            }
        }

        public @NonNull ImmutableList<OrientedImageTitle> buildResult() {
            return ImmutableList.copyOf(fitImages);
        }
    }
}
