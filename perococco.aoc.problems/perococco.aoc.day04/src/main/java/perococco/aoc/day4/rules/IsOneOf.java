package perococco.aoc.day4.rules;

import com.google.common.collect.ImmutableSet;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IsOneOf implements Rule<String,String> {

    public static @NonNull IsOneOf these(@NonNull String... expectedValues) {
        return new IsOneOf(ImmutableSet.copyOf(expectedValues));
    }

    private final @NonNull ImmutableSet<String> expectedValues;

    @Override
    public @NonNull Validation<String> validate(@NonNull String input) {
        if (expectedValues.contains(input)) {
            return Validation.valid(input);
        }
        return Validation.invalid();
    }
}
