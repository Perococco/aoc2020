package perococco.aoc.day19.structures;

import lombok.NonNull;

import java.util.stream.Stream;

public interface RuleVisitor {

    @NonNull Stream<IndexedString> visit(@NonNull IndexedString parameter, @NonNull Or or);

    @NonNull Stream<IndexedString> visit(@NonNull IndexedString parameter, @NonNull Concatenation concatenation);

    @NonNull Stream<IndexedString> visit(@NonNull IndexedString parameter, @NonNull Literal literal);

}
