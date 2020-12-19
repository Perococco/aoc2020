package perococco.aoc.day19.structures;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class BasicMatcher implements Predicate<String> {

    private final @NonNull ImmutableMap<Integer, Rule> rules;

    private final Visitor visitor = new Visitor();

    @Override
    public boolean test(String message) {
        return rules.get(0)
                    .accept(visitor, IndexedString.initial(message))
                    .anyMatch(IndexedString::isEmpty);
    }

    private class Visitor implements RuleVisitor {

        @Override
        public @NonNull Stream<IndexedString> visit(@NonNull IndexedString parameter, @NonNull Or or) {
            return Stream.of(or.first(), or.second())
                         .flatMap(r -> r.accept(this, parameter));
        }

        @Override
        public @NonNull Stream<IndexedString> visit(@NonNull IndexedString indexedString, @NonNull Concatenation concatenation) {
            return concatenation.ruleIds()
                                .stream()
                                .sequential()
                                .map(rules::get)
                                .reduce(Stream.of(indexedString),
                                        (stream, rule) -> stream.flatMap(m -> rule.accept(this, m)),
                                        Stream::concat);
        }

        @Override
        public @NonNull Stream<IndexedString> visit(@NonNull IndexedString parameter, @NonNull Literal literal) {
            if (!parameter.isEmpty() && parameter.charAt(0) == literal.value()) {
                return Stream.of(parameter.addToOffset(1));
            }
            return Stream.empty();
        }

    }

}