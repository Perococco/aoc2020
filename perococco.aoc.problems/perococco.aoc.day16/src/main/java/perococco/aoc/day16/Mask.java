package perococco.aoc.day16;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Mask {

    public static @NonNull Mask create(@NonNull ImmutableSet<Field> fields) {
        final boolean[] inRangeFlags = new boolean[1000];
        fields.forEach(f -> f.setValidityFlags(inRangeFlags));
        return new Mask(inRangeFlags);
    }

    private final boolean[] inRangeFlags;

    public boolean isValid(int value) {
        return inRangeFlags[value];
    }

    public boolean isNotValid(int value) {
        return !inRangeFlags[value];
    }

    public boolean isValid(@NonNull Ticket ticket) {
        return ticket.values().allMatch(this::isValid);
    }
}
