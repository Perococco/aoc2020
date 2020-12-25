package perococco.aoc.day25;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.Value;

@Value
public class Day25Input {
    int doorPublicKey;
    int cardPublicKey;

    public static @NonNull Day25Input parse(ImmutableList<String> strings) {
        return new Day25Input(Integer.parseInt(strings.get(0)),Integer.parseInt(strings.get(1)));
    }
}
