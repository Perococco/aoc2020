package perococco.aoc.day2;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day2.structures.DatabaseEntry;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.function.Function;
import java.util.stream.Stream;

public class Day2Part1Solver extends Day2Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day2Part1Solver().createProblem();
    }


    @Override
    protected Function<? super String, ? extends DatabaseEntry> getDatabaseEntryParser() {
        return DatabaseEntry::parseWithOldRule;
    }

    @Override
    public @NonNull Long solve(@NonNull Stream<DatabaseEntry> input) {
        return input.filter(DatabaseEntry::isEntryValid).count();
    }

}
