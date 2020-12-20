package perococco.aoc.day19.structures;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class Literal implements Rule {

    static @NonNull Literal parse(@NonNull String line) {
        return new Literal(line.trim().charAt(1));
    }

    @Getter
    private final char value;

    @Override
    public <I, O> @NonNull O accept(@NonNull RuleVisitor<I, O> visitor, @NonNull I parameter) {
        return visitor.visit(this, parameter);
    }

}
