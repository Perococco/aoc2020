package perococco.aoc.day2;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day2.structures.DatabaseEntry;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.stream.Stream;

public class Day2Part1Solver extends SmartSolver<Stream<DatabaseEntry>,Integer> {

    public static @NonNull AOCProblem<?> provider() {
        return new Day2Part1Solver().createProblem();
    }

    @Override
    protected @NonNull Converter<Stream<DatabaseEntry>> getConverter() {
        return s -> s.map(DatabaseEntry::parseWithOldRule);
    }

    @Override
    public @NonNull Integer solve(@NonNull Stream<DatabaseEntry> input) {
        return Math.toIntExact(input.filter(DatabaseEntry::isEntryValid).count());
    }

}
