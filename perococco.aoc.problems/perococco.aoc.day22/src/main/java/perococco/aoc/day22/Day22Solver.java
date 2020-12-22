package perococco.aoc.day22;

import lombok.NonNull;
import perococco.aoc.day22.structures.GameSetup;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

public abstract class Day22Solver<O> extends SmartSolver<GameSetup,O> {

    @Override
    protected @NonNull Converter<GameSetup> getConverter() {
        return Converter.ALL_LINES.andThen(GameSetup::parse);
    }
}
