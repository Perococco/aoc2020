package perococco.aoc.day20.structures;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.Tools;

import java.util.function.Function;

@RequiredArgsConstructor
public enum Orientation {
    _0(0),
    _90(3),
    _180(2),
    _270(1),
    ;

    private final int index;

    public @NonNull String getRight(@NonNull ImageTile imageTile, boolean flipped) {
        if (flipped) {
            return Tools.reverse(getBorder(imageTile,index+3));
        }
        return getBorder(imageTile,index+1);
    }
    public @NonNull String getDown(@NonNull ImageTile imageTile, boolean flipped) {
        final var value = getBorder(imageTile,index+2);
        return flipped?Tools.reverse(value):value;
    }

    public @NonNull Orientation inverse() {
        return switch (this) {
            case _0 -> _0;
            case _90 -> _270;
            case _180 -> _180;
            case _270 -> _90;
        };
    }

    private @NonNull String getBorder(@NonNull ImageTile imageTile, int index) {
        final int mod = Tools.mod(index,NB_EXTRACTORS);
        final String border = BORDER_EXTRACTORS.get(mod).apply(imageTile);
        return Tools.reverse(border);
    }

    private static final int NB_EXTRACTORS = 4;

    private static ImmutableList<Function<ImageTile,String>> BORDER_EXTRACTORS = ImmutableList.of(
            ImageTile::extractUpperBorder,
            ImageTile::extractRightBorder,
            ImageTile::extractBottomBorder,
            ImageTile::extractLeftBorder
    );

    public int getX(int x, int y, int width, boolean flipped) {
        return switch (this) {
            case _0 -> flipped?width-1-x:x;
            case _90 -> y;
            case _180 -> flipped?x:width-1-x;
            case _270 -> width-1-y;
        };
    }

    public int getY(int x, int y, int width, boolean flipped) {
        return switch (this) {
            case _0 -> y;
            case _90 -> flipped?x:width-1-x;
            case _180 -> width-1-y;
            case _270 -> flipped?width-1-x:x;
        };
    }

}
