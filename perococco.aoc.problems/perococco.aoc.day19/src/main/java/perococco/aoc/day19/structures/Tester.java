package perococco.aoc.day19.structures;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class Tester implements Predicate<String> {

    private final @NonNull ImmutableMap<Integer, Rule> rules;

    private final Visitor visitor = new Visitor();

    @Override
    public boolean test(String message) {
        return rules.get(0)
                    .accept(visitor, IndexedString.initial(message))
                    .anyMatch(IndexedString::isEmpty);
    }

    /**
     * For each rule and one IndexedString, return a stream of potential match
     */
    private class Visitor implements RuleVisitor<IndexedString, Stream<IndexedString>> {

        @Override
        public @NonNull Stream<IndexedString> visit(@NonNull Or or, @NonNull IndexedString parameter) {
            return Stream.of(or.first(), or.second())
                         .flatMap(r -> r.accept(this, parameter));
        }

        @Override
        public @NonNull Stream<IndexedString> visit(@NonNull Concatenation concatenation, @NonNull IndexedString indexedString) {
            return concatenation.ruleIds()
                                .stream()
                                .sequential()
                                .map(rules::get)
                                .reduce(Stream.of(indexedString),
                                        (stream, rule) -> stream.flatMap(m -> rule.accept(this, m)),
                                        Stream::concat);
        }

        @Override
        public @NonNull Stream<IndexedString> visit(@NonNull Literal literal, @NonNull IndexedString parameter) {
            if (!parameter.isEmpty() && parameter.charAt(0) == literal.value()) {
                return Stream.of(parameter.addToOffset(1));
            }
            return Stream.empty();
        }

    }

}