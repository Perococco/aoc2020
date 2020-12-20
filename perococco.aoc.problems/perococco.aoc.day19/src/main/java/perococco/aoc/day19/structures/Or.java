package perococco.aoc.day19.structures;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

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
    public <I, O> @NonNull O accept(@NonNull RuleVisitor<I, O> visitor, @NonNull I parameter) {
        return visitor.visit(this, parameter);
    }

    public static @NonNull Or or(@NonNull Concatenation first, @NonNull Concatenation second) {
        return new Or(first, second);
    }

}
