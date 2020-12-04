package perococco.aoc.day4.rules;

import lombok.NonNull;

public class AreAllDigits implements Rule<String,String> {

    public static AreAllDigits create() {
        return new AreAllDigits();
    }

    @Override
    public @NonNull Validation<String> validate(@NonNull String input) {
        if (input.chars().allMatch(i -> i >= '0' && i<='9')) {
            return Validation.valid(input);
        }
        return Validation.invalid();
    }
}
