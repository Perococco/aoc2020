package perococco.aoc.input;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SingleLineInput implements Input<String> {

    private final @NonNull String data;

    @Override
    public @NonNull String readData() {
        return data;
    }
}
