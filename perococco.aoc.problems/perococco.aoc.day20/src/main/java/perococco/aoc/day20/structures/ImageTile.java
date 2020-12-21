package perococco.aoc.day20.structures;

import com.google.common.collect.ImmutableList;
import lombok.*;
import perococco.aoc.common.ArrayOfChar;

import java.util.function.IntUnaryOperator;

@Value
public class ImageTile {

    @Getter
    int id;
    @Getter
    @NonNull ArrayOfChar arrayOfChar;

    @Builder
    public ImageTile(int id, @Singular(value = "datum") @NonNull ImmutableList<String> data) {
        this.id = id;
        this.arrayOfChar = data.stream().collect(ArrayOfChar.collector('.'));
    }

    public @NonNull String extractUpperBorder() {
        return extract(i -> i, i -> 0);
    }

    public @NonNull String extractRightBorder() {
        return extract(i -> width()-1, i -> i);
    }

    public @NonNull String extractBottomBorder() {
        return extract(i -> width()-1-i,i -> width()-1);
    }

    public @NonNull String extractLeftBorder() {
        return extract(i -> 0, i -> width()-1-i);
    }



    private @NonNull String extract(@NonNull IntUnaryOperator x, @NonNull IntUnaryOperator y) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width(); i++) {
            sb.append(arrayOfChar.get(x.applyAsInt(i),y.applyAsInt(i)));
        }
        return sb.toString();

    }

    public int width() {
        return arrayOfChar.width();
    }
}
