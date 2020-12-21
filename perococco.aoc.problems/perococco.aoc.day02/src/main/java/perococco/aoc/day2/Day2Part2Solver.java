package perococco.aoc.day2;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day2.structures.DatabaseEntry;

import java.util.function.Function;
import java.util.stream.Stream;

public class Day2Part2Solver extends Day2Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day2Part2Solver().createProblem();
    }

    @Override
    protected Function<? super String, ? extends DatabaseEntry> getDatabaseEntryParser() {
        return DatabaseEntry::parseWithNewRule;
    }

    @Override
    public @NonNull Long solve(@NonNull Stream<DatabaseEntry> input) {
        return input.filter(DatabaseEntry::isEntryValid).count();
    }
}
