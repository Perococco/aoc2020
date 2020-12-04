package perococco.aoc.day4.structures;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import perococco.aoc.common.AOCException;
import perococco.aoc.common.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PassportBuilder {

    private final Map<FieldName, String> fields = new HashMap<>();

    public void addLine(@NonNull String line) {
        if (line.isBlank()) {
            throw new AOCException("Blank line not expected");
        }
        Arrays.stream(line.split("\\s"))
              .map(PassportBuilder::parseField)
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
