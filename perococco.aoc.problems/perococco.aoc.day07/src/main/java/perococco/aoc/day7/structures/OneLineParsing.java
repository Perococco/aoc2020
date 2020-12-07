package perococco.aoc.day7.structures;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OneLineParsing {

    @Getter
    private final @NonNull String colorName;

    @Getter
    private final @NonNull ImmutableMap<String,Integer> content;
}
