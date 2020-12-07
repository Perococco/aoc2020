package perococco.aoc.day7.structures;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BagGraphBuilder  {

    public static @NonNull BagGraph build(@NonNull ImmutableList<String> lines) {
        return new BagGraphBuilder(lines).build();
    }

    private final @NonNull ImmutableList<String> lines;

    private final @NonNull Map<String,BagNode> nodes = new HashMap<>();

    private @NonNull BagGraph build() {
        for (String line : lines) {
            handleOneLine(line);
        }
        return new BagGraph(ImmutableMap.copyOf(nodes));
    }

    private void handleOneLine(String line) {
        final var parsing = OneLineParser.parse(line);
        final var container = getBagNodeFromColorName(parsing.colorName());

        for (var entry : parsing.content().entrySet()) {
            final var contained = getBagNodeFromColorName(entry.getKey());
            container.addToContent(contained,entry.getValue());
        }
    }

    private @NonNull BagNode getBagNodeFromColorName(@NonNull String colorName) {
        return  nodes.computeIfAbsent(colorName,BagNode::new);
    }

}
