package perococco.aoc.day4.rules;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StartsWith implements Rule<String,String> {

    public static StartsWith prefix(@NonNull String prefix) {
        return new StartsWith(prefix);
    }

    private final @NonNull String suffix;

    @Override
    public @NonNull Validation<String> validate(@NonNull String input) {
        if (input.startsWith(suffix)) {
            return Validation.valid(input.substring(suffix.length(),input.length()));
        }
        return Validation.invalid();
    }
}
