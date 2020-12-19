package perococco.aoc.day19.structures;

import com.google.common.collect.ImmutableSet;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.stream.Stream;

@RequiredArgsConstructor
@ToString
public class Or implements Rule {

    static @NonNull Or parse(@NonNull String line) {
        final var tokens = line.trim().split("\\|");
        return new Or(Concatenation.parse(tokens[0]), Concatenation.parse(tokens[1]));
    }

    @Getter
    private final @NonNull Concatenation first;

    @Getter
    private final @NonNull Concatenation second;

    @Override
    public @NonNull Stream<IndexedString> accept(@NonNull RuleVisitor visitor, @NonNull IndexedString parameter) {
        return visitor.visit(parameter, this);
    }

    public static @NonNull Or or(@NonNull Concatenation first, @NonNull Concatenation second) {
        return new Or(first, second);
    }

}
