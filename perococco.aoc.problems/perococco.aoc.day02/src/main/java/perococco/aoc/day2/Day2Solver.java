package perococco.aoc.day2;

import lombok.NonNull;
import perococco.aoc.day2.structures.DatabaseEntry;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.function.Function;
import java.util.stream.Stream;

public abstract class Day2Solver extends SmartSolver<Stream<DatabaseEntry>,Long> {

    protected abstract Function<? super String,? extends DatabaseEntry> getDatabaseEntryParser();

    @Override
    protected @NonNull Converter<Stream<DatabaseEntry>> getConverter() {
        return s -> s.map(getDatabaseEntryParser());
    }
}
