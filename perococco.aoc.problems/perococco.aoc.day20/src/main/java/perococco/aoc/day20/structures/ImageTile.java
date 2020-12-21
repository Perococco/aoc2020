package perococco.aoc.day20.structures;

import com.google.common.collect.ImmutableList;
import lombok.*;
import perococco.aoc.common.ArrayOfChar;
import perococco.aoc.common.Tools;

@Value
public class ImageTile {

    @Getter
    int id;

    @Getter
    @NonNull ImmutableList<String> data;
    @Getter
    @NonNull ArrayOfChar arrayOfChar;

    @Builder
    public ImageTile(int id, @Singular(value = "datum") @NonNull ImmutableList<String> data) {
        this.id = id;
        this.data = data;
        this.arrayOfChar = data.stream().collect(ArrayOfChar.collector('.'));
    }

    public @NonNull String extractUpperBorder() {
        return data.get(0);
    }

    public @NonNull String extractRightBorder() {
        final StringBuilder sb = new StringBuilder();
        for (String datum : data) {
            sb.append(datum.charAt(datum.length()-1));
        }
        return sb.toString();
    }

    public @NonNull String extractLeftBorder() {
        final StringBuilder sb = new StringBuilder();
        for (String datum : data.reverse()) {
            sb.append(datum.charAt(0));
        }
        return sb.toString();
    }

    public @NonNull String extractBottomBorder() {
        return Tools.reverse(data.get(data.size()-1));
    }

    @Override
    public String toString() {
        return String.join("\n", data);
    }

    public int width() {
        return data.size();
    }
}
