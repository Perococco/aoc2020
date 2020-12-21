package perococco.aoc.day20.structures;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Table;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.Transformation;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DictionaryBuilder {

    public static @NonNull Dictionary build(@NonNull ImmutableList<ImageTile> imageTiles) {
        return new DictionaryBuilder(imageTiles).build();
    }

    private final ImmutableList<ImageTile> imageTiles;

    private final Table<String, String, Set<ImageTile>> table = HashBasedTable.create();

    private @NonNull Dictionary build() {
        for (ImageTile imageTile : imageTiles) {
            addOneImageTile(imageTile);
        }
        return new Dictionary(table);
    }

    private void addOneImageTile(final @NonNull ImageTile imageTile) {
        Transformation.all()
                      .map(imageTile::transform)
                      .forEach(this::addToTable);
    }

    private void addToTable(ImageTile imageTile) {
        final var left = imageTile.leftBorder();
        final var up = imageTile.upperBorder();
        Set<ImageTile> set = table.get(left, up);
        if (set == null) {
            set = new HashSet<>();
            table.put(left, up, set);
        }
        set.add(imageTile);
    }

}
