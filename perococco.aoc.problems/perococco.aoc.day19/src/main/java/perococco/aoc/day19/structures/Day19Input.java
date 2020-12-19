package perococco.aoc.day19.structures;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.*;
import perococco.aoc.common.AOCException;
import perococco.aoc.common.Pair;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;

@RequiredArgsConstructor
@Builder
public class Day19Input {

    @Singular
    @Getter
    private final @NonNull ImmutableMap<Integer, Rule> rules;

    @Singular
    @Getter
    private final @NonNull ImmutableList<String> messages;


    /** PARSING **/
    public static @NonNull Day19Input parse(@NonNull String string) {
        return parse(Arrays.stream(string.split("\n")).collect(ImmutableList.toImmutableList()));
    }

    public static @NonNull Day19Input parse(ImmutableList<String> strings) {
        final var builder = Day19Input.builder();
        Consumer<String> parser = string -> {
            final var pair = parseRule(string);
            builder.rule(pair.first(),pair.second());
        };
        for (String string : strings) {
            if (string.isBlank()) {
                parser = builder::message;
                continue;
            }
            parser.accept(string);
        }
        return builder.build();
    }

    private static Pair<Integer,Rule> parseRule(@NonNull String ruleAsString) {
        try {
            final int idx = ruleAsString.indexOf(":");
            final int ruleId = Integer.parseInt(ruleAsString.substring(0, idx));
            final Rule rule = Rule.parse(ruleAsString.substring(idx + 1));
            return Pair.of(ruleId, rule);
        } catch (Exception e) {
            throw new AOCException("Could not parse '"+ruleAsString+"'",e);
        }
    }


    public @NonNull Rule findRule(int id) {
        return rules.get(id);
    }

    public Day19Input replaceRules(@NonNull Map<Integer, Rule> newRules) {
        final ImmutableMap.Builder<Integer,Rule> builder = ImmutableMap.builder();
        for (Map.Entry<Integer, Rule> entry : rules.entrySet()) {
            builder.put(entry.getKey(), newRules.getOrDefault(entry.getKey(),entry.getValue()));
        }
        return new Day19Input(builder.build(),messages);
    }
}
