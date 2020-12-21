package perococco.aoc.day20.structures;

import com.google.common.collect.ImmutableList;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Parser {

    public static @NonNull ImmutableList<ImageTile> parse(@NonNull ImmutableList<String> lines) {
        return new Parser(lines).parse();
    }

    private final @NonNull ImmutableList<String> lines;

    private final ImmutableList.Builder<ImageTile> tileListBuilder = ImmutableList.builder();
    private ImageTile.ImageTileBuilder imageTileBuilder;

    private @NonNull ImmutableList<ImageTile> parse() {
        this.initializeImageTileBuilder();
        for (String line : lines) {
            if (line.isBlank()) {
                this.addImageTileInProgressToListOfTile();
            } else if (line.startsWith("Tile ")) {
                this.initializeImageTileBuilder();
                this.parseImageTileId(line);
            } else {
                this.parseDataLine(line);
            }
        }
        this.addImageTileInProgressToListOfTile();
        return tileListBuilder.build();
    }

    private void addImageTileInProgressToListOfTile() {
        if (this.imageTileBuilder != null) {
            this.tileListBuilder.add(this.imageTileBuilder.build());
        }
        this.imageTileBuilder = null;
    }

    private void initializeImageTileBuilder() {
        this.imageTileBuilder = ImageTile.builder();
    }

    private void parseImageTileId(String line) {
        final int id = Integer.parseInt(line.substring("Tile ".length(), line.length() - 1));
        imageTileBuilder.id(id);
    }

    private void parseDataLine(String line) {
        imageTileBuilder.datum(line);
    }

}
