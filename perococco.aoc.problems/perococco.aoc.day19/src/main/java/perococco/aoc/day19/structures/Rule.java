package perococco.aoc.day19.structures;

import com.google.common.collect.ImmutableSet;
import lombok.NonNull;

import java.util.stream.Stream;

public interface Rule {

    @NonNull Stream<IndexedString> accept(@NonNull RuleVisitor visitor, @NonNull IndexedString parameter);

    static @NonNull Rule parse(@NonNull String line) {
        final int indexOfPipe = line.indexOf('|');
        final int indexOfQuote = line.indexOf('"');
        if (indexOfPipe>=0) {
            return Or.parse(line);
        }
        if (indexOfQuote>=0) {
            return Literal.parse(line);
        }
        return Concatenation.parse(line);
    }

}
