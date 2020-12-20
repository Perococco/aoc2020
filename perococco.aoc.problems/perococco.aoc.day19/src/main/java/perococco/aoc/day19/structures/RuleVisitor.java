package perococco.aoc.day19.structures;

import lombok.NonNull;

public interface RuleVisitor<I,O> {

    @NonNull O visit(@NonNull Or or, @NonNull I parameter);

    @NonNull O visit(@NonNull Concatenation concatenation, @NonNull I parameter);

    @NonNull O visit(@NonNull Literal literal, @NonNull I parameter);

}
