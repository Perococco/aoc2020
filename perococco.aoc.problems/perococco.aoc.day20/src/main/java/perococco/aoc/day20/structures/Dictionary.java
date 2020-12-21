package perococco.aoc.day20.structures;

import com.google.common.collect.Table;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class Dictionary {

    @NonNull
    private final Table<String, String, Set<OrientedImageTitle>> table;

    public @NonNull Stream<OrientedImageTitle> findWithUpMatching(@NonNull String down) {
        return Optional.ofNullable(table.column(down))
                       .stream()
                       .map(Map::values)
                       .flatMap(Collection::stream)
                       .flatMap(Collection::stream);
    }

    public @NonNull Stream<OrientedImageTitle> findWithLeftMatching(@NonNull String right) {
        return Optional.ofNullable(table.row(right))
                       .stream()
                       .map(Map::values)
                       .flatMap(Collection::stream)
                       .flatMap(Collection::stream);
    }

    public @NonNull Stream<OrientedImageTitle> findWithLeftAndUpMatching(@NonNull String right, @NonNull String down) {
        return Optional.ofNullable(table.get(right,down))
                       .stream()
                       .flatMap(Collection::stream);

    }

    public @NonNull Stream<OrientedImageTitle> allTiles() {
        return table.values().stream().flatMap(Collection::stream);
    }
}
