package perococco.aoc.day19.structures;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import perococco.aoc.common.AOCException;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RequiredArgsConstructor
@ToString
public class Concatenation implements Rule {

    @Getter
    private final @NonNull ImmutableList<Integer> ruleIds;

    @Override
    public Stream<IndexedString> matches(@NonNull IndexedString string, @NonNull RuleProvider ruleProvider) {
        return ruleIds.stream()
                .map(ruleProvider)
                .reduce(Stream.of(string),
                        (stream, rule) -> stream.flatMap(m -> rule.matches(m,ruleProvider)),
                        Stream::concat);

    }

    public static @NonNull Concatenation concatenation(int... ruleIds) {
        return new Concatenation(IntStream.of(ruleIds).boxed().collect(ImmutableList.toImmutableList()));
    }

    static @NonNull Concatenation parse(@NonNull String line) {
        try {
            final var ruleIds = Arrays.stream(line.trim().split(" "))
                                      .map(Integer::parseInt)
                                      .collect(ImmutableList.toImmutableList());
            return new Concatenation(ruleIds);
        } catch (Exception e) {
            throw new AOCException("This line is not a concatenation rule '" + line + "'",e);
        }
    }

}
