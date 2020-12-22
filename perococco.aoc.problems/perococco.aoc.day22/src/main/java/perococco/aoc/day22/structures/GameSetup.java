package perococco.aoc.day22.structures;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;
import java.util.function.Function;

@RequiredArgsConstructor
public class GameSetup {

    @Getter
    private final @NonNull ImmutableList<Integer> player1;
    @Getter
    private final @NonNull ImmutableList<Integer> player2;

    public static @NonNull GameSetup parse(@NonNull ImmutableList<String> lines) {
        final var card1 = ImmutableList.<Integer>builder();
        final var card2 = ImmutableList.<Integer>builder();
        final Function<ImmutableList.Builder<Integer>, Consumer<String>> setterFactory = queue -> s -> queue.add(Integer.parseInt(s));
        Consumer<String> setter = null;
        for (String line : lines) {
            if (line.isBlank()) {
                setter = null;
            } else if (line.startsWith("Player 1:")) {
                setter = setterFactory.apply(card1);
            } else if (line.startsWith("Player 2:")) {
                setter = setterFactory.apply(card2);
            } else {
                assert setter != null;
                setter.accept(line);
            }
        }
        return new GameSetup(card1.build(), card2.build());
    }
}
