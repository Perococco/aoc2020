package perococco.aoc.day20.structures;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Table;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.Tools;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DictionaryBuilder {

    public static @NonNull Dictionary build(@NonNull ImmutableList<ImageTile> imageTiles) {
        return new DictionaryBuilder(imageTiles).build();
    }

    private final ImmutableList<ImageTile> imageTiles;

    private final Table<String, String, Set<OrientedImageTitle>> table = HashBasedTable.create();

    private @NonNull Dictionary build() {
        for (ImageTile imageTile : imageTiles) {
            addOneImageTile(imageTile);
        }
        return new Dictionary(table);
    }

    private void addOneImageTile(@NonNull ImageTile imageTile) {
        final String a = imageTile.extractUpperBorder();
        final String b = imageTile.extractRightBorder();
        final String c = imageTile.extractBottomBorder();
        final String d = imageTile.extractLeftBorder();
        //
        //         N           F
        //         A           A'
        //  0    D   B       B'   D'
        //         C           C'
        //         D           D'
        //  90   C   A       A'   C'
        //         B           B'
        //         C           C'
        //180    B   D        D'  B'
        //         A           A'
        //        B            B'
        //270    A C          C' A'
        //        D            D'
        //

        this.addToTable(d, a, new OrientedImageTitle(Orientation._0, false, imageTile));
        this.addToTable(c, d, new OrientedImageTitle(Orientation._90, false, imageTile));
        this.addToTable(b, c, new OrientedImageTitle(Orientation._180, false, imageTile));
        this.addToTable(a, b, new OrientedImageTitle(Orientation._270, false, imageTile));

        this.addToTable(Tools.reverse(b), Tools.reverse(a), new OrientedImageTitle(Orientation._0, true, imageTile));
        this.addToTable(Tools.reverse(a), Tools.reverse(d), new OrientedImageTitle(Orientation._90, true, imageTile));
        this.addToTable(Tools.reverse(d), Tools.reverse(c), new OrientedImageTitle(Orientation._180, true, imageTile));
        this.addToTable(Tools.reverse(c), Tools.reverse(b), new OrientedImageTitle(Orientation._270, true, imageTile));

    }

    private void addToTable(String left, String up, OrientedImageTitle orientedImageTitle) {
        Set<OrientedImageTitle> set = table.get(left, up);
        if (set == null) {
            set = new HashSet<>();
            table.put(left, up, set);
        }
        set.add(orientedImageTitle);
    }

}
