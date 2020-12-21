package perococco.aoc.day20.structures;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.common.Array;
import perococco.aoc.common.ArrayOfChar;
import perococco.aoc.common.GenericArray;
import perococco.aoc.common.Tools;

import java.util.Arrays;
import java.util.stream.Stream;

public class ImageArray extends GenericArray<ImageTile> {

    public static ImageArray with(@NonNull ImmutableList<ImageTile> tiles) {
        final int width = Tools.sqrt(tiles.size());
        return new ImageArray(tiles.toArray(new ImageTile[0]),width,width);
    }

    private ImageArray(@NonNull ImageTile[] data, int width, int height) {
        super(data, width, height);
    }

    public @NonNull Stream<ImageTile> corners() {
        return Stream.of(
                get(0,0),
                get(0,height()-1),
                get(width()-1,0),
                get(width()-1,height()-1)
        );
    }

    public @NonNull ArrayOfChar buildImageArray() {
        final ImageTile any = get(0,0);
        final int tileWidth = any.width();
        final int imageWidth = (tileWidth+1)*width()-1;
        final char[] data = new char[imageWidth*imageWidth];
        Arrays.fill(data,' ');
        for (int y = 0; y < height(); y++) {
            for (int x = 0; x < width(); x++) {
                final int ix = x*(tileWidth+1);
                final int iy = y*(tileWidth+1);
                get(x,y).copyTo(data,
                                ix+iy*imageWidth, imageWidth,
                                0,0,
                                tileWidth,tileWidth
                );
            }
        }

        return ArrayOfChar.of(data,'.',imageWidth, imageWidth);
    }

    public @NonNull ArrayOfChar buildImage() {
        final ImageTile any = get(0,0);
        final int tileWidth = any.width();

        final int imageWidth = (tileWidth-2)*width();
        final char[] data = new char[imageWidth*imageWidth];

        for (int y = 0; y < height(); y++) {
            for (int x = 0; x < width(); x++) {
                final int ix = x*(tileWidth-2);
                final int iy = y*(tileWidth-2);
                get(x,y).copyTo(data,
                                ix+iy*imageWidth, imageWidth,
                                1,1,
                                tileWidth-2,tileWidth-2
                                );
            }
        }
        return ArrayOfChar.of(data,'.', imageWidth,imageWidth);
    }
}
