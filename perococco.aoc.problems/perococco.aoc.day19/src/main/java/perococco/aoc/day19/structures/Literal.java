package perococco.aoc.day19.structures;

import com.google.common.collect.ImmutableSet;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.stream.Stream;

@RequiredArgsConstructor
@ToString
public class Literal implements Rule {

    static @NonNull Literal parse(@NonNull String line) {
        return new Literal(line.trim().charAt(1));
    }

    @Getter
    private final char value;

    @Override
    public @NonNull Stream<IndexedString> accept(@NonNull RuleVisitor visitor, @NonNull IndexedString parameter) {
        return visitor.visit(parameter,this);
    }

}
