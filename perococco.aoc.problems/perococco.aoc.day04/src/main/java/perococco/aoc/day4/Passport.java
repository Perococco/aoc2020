package perococco.aoc.day4;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.AOCException;
import perococco.aoc.common.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class Passport {

    private final @NonNull ImmutableMap<FieldName, String> fields;

    public boolean hasFields(@NonNull ImmutableSet<FieldName> compulsoryFields) {
        return fields.keySet().containsAll(compulsoryFields);
    }


    public static Builder builder() {
        return new Builder();
    }

    public @NonNull Optional<String> getField(@NonNull FieldName fieldName) {
        return Optional.ofNullable(fields.get(fieldName));
    }


    public static class Builder {

        private final Map<FieldName, String> fields = new HashMap<>();

        public void addLine(@NonNull String line) {
            if (line.isBlank()) {
                throw new AOCException("Blank line not expected");
            }
            Arrays.stream(line.split("\\s"))
                  .map(Builder::parseField)
                  .forEach(p -> p.addToMap(fields));

        }

        public @NonNull Passport build() {
            return new Passport(ImmutableMap.copyOf(fields));
        }

        private static @NonNull Pair<FieldName, String> parseField(@NonNull String token) {
            final int idx = token.indexOf(":");
            if (idx <= 0) {
                throw new AOCException("Cannot parse field token '" + token + "'");
            }
            final FieldName fieldName = FieldName.fromId(token.substring(0, idx));
            final String value = idx >= token.length() - 1 ? "" : token.substring(idx + 1);
            return Pair.of(fieldName, value);
        }

    }


}
