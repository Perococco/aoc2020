package perococco.aoc.day6;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.day6.structures.Group;
import perococco.aoc.day6.structures.GroupListBuilder;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

public abstract class Day6Solver extends SmartSolver<ImmutableList<Group>,Integer> {

    @Override
    protected @NonNull Converter<ImmutableList<Group>> getConverter() {
        return Converter.ALL_LINES.andThen(GroupListBuilder::build);
    }
}
