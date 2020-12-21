package perococco.aoc.day20.structures;

import com.google.common.collect.ImmutableList;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.ArrayOfChar;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Parser {

    public static @NonNull ImmutableList<ImageTile> parse(@NonNull ImmutableList<String> lines) {
        return new Parser(lines).parse();
    }

    private final @NonNull ImmutableList<String> lines;

    private final ImmutableList.Builder<ImageTile> tileListBuilder = ImmutableList.builder();
    private ImageTileBuilder imageTileBuilder;

    private @NonNull ImmutableList<ImageTile> parse() {
        this.initializeImageTileBuilder();
        for (String line : lines) {
            if (line.isBlank()) {
                this.addImageTileInProgressToListOfTiles();
            } else if (line.startsWith("Tile ")) {
                this.initializeImageTileBuilder();
                this.parseImageTileId(line);
            } else {
                this.parseDataLine(line);
            }
        }
        this.addImageTileInProgressToListOfTiles();
        return tileListBuilder.build();
    }

    private void addImageTileInProgressToListOfTiles() {
        if (this.imageTileBuilder != null) {
            this.tileListBuilder.add(this.imageTileBuilder.build());
        }
        this.imageTileBuilder = null;
    }

    private void initializeImageTileBuilder() {
        this.imageTileBuilder = new ImageTileBuilder();
    }

    private void parseImageTileId(String line) {
        final int id = Integer.parseInt(line.substring("Tile ".length(), line.length() - 1));
        imageTileBuilder.id(id);
    }

    private void parseDataLine(String line) {
        imageTileBuilder.datum(line);
    }


    private static class ImageTileBuilder {

        private Integer id;
        private ImmutableList.Builder<String> data = ImmutableList.builder();

        public void id(int id) {
            this.id = id;
        }

        public void datum(@NonNull String line) {
            this.data.add(line);
        }

        public @NonNull ImageTile build() {
            return new ImageTile(id, ArrayOfChar.from(data.build(),'.'));
        }
    }
}
