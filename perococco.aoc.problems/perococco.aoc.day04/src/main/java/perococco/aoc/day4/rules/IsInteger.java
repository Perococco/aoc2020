package perococco.aoc.day4.rules;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IsInteger implements Rule<String,Integer> {

    public static IsInteger create() {
        return new IsInteger();
    }

    @Override
    public @NonNull Validation<Integer> validate(@NonNull String input) {
        try {
            return Validation.valid(Integer.parseInt(input));
        } catch (NumberFormatException nfe) {
            return Validation.invalid();
        }
    }
}
