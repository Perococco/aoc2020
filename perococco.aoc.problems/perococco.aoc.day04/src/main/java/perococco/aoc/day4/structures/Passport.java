package perococco.aoc.day4.structures;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class Passport {

    /**
     * The fields present in the passport
     */
    private final @NonNull ImmutableMap<FieldName, String> fields;

    /**
     * @param fields the fields to check
     * @return true if this password contains the provided fields
     */
    public boolean hasFields(@NonNull ImmutableSet<FieldName> fields) {
        return this.fields.keySet().containsAll(fields);
    }

    public @NonNull Optional<String> getField(@NonNull FieldName fieldName) {
        return Optional.ofNullable(fields.get(fieldName));
    }

    public static PassportBuilder builder() {
        return new PassportBuilder();
    }



}
