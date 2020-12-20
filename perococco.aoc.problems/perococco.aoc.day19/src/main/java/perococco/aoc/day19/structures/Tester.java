package perococco.aoc.day19.structures;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;

@RequiredArgsConstructor
public class Tester implements Predicate<String> {

    private final @NonNull ImmutableMap<Integer, Rule> rules;

    @Override
    public boolean test(String message) {
        return rules.get(0)
                    .matches(IndexedString.initial(message), rules::get)
                    .anyMatch(IndexedString::isEmpty);
    }


}