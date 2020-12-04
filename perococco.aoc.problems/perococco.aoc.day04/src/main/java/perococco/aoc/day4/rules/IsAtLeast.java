package perococco.aoc.day4.rules;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IsAtLeast implements Rule<Integer,Integer> {

    private final int limit;

    @Override
    public @NonNull Validation<Integer> validate(@NonNull Integer input) {
        if (input>=limit) {
            return Validation.valid(input);
        }
        return Validation.invalid();
    }
}
