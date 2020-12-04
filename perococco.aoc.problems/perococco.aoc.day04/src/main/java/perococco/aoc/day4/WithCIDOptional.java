package perococco.aoc.day4;

import com.google.common.collect.ImmutableSet;
import lombok.NonNull;

import java.util.Arrays;

public class WithCIDOptional implements ValidityRule {

    private final @NonNull ImmutableSet<FieldName> compulsoryFields = Arrays.stream(FieldName.values())
                                                                            .filter(f -> f!=FieldName.CID)
                                                                            .collect(ImmutableSet.toImmutableSet());

    @Override
    public boolean isValid(@NonNull Passport passport) {
        return passport.hasFields(compulsoryFields);
    }
}
