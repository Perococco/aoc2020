package perococco.aoc.day12;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.day12.structures.Movement;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

public abstract class Day12Solver extends SmartSolver<ImmutableList<Movement>,Integer> {

    @Override
    protected @NonNull Converter<ImmutableList<Movement>> getConverter() {
        return s -> s.map(Movement::parse).collect(ImmutableList.toImmutableList());
    }
}
