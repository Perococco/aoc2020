package perococco.aoc.day20.structures;

import lombok.Getter;
import lombok.NonNull;
import perococco.aoc.common.ArrayOfChar;

import java.util.concurrent.atomic.AtomicReference;


@Getter
public class OrientedImageTitle {

    private @NonNull Orientation orientation;
    private boolean flipped;
    private @NonNull ImageTile imageTile;
    private @NonNull String matchingRight;
    private @NonNull String matchingDown;


    public OrientedImageTitle(@NonNull Orientation orientation, boolean flipped, @NonNull ImageTile imageTile) {
        this.orientation = orientation;
        this.flipped = flipped;
        this.imageTile = imageTile;
        this.matchingRight = orientation.getRight(imageTile, flipped);
        this.matchingDown = orientation.getDown(imageTile, flipped);

    }

    public int getImageTileId() {
        return imageTile.id();
    }

    private final AtomicReference<String> toString = new AtomicReference<>(null);

    public @NonNull String toString() {
        return toString.updateAndGet(v -> v == null ? asArrayOfChar().toString() : v);
    }

    public ArrayOfChar asArrayOfChar() {
        final ArrayOfChar tile = imageTile.arrayOfChar();
        final int width = tile.width();
        ArrayOfChar result = new ArrayOfChar(new char[width*width],'.',width,width);
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < width; x++) {
                int ox = orientation.getX(x, y, width, flipped);
                int oy = orientation.getY(x, y, width, flipped);
                result.set(x,y,tile.get(ox,oy));
            }
        }
        return result;
    }





}
