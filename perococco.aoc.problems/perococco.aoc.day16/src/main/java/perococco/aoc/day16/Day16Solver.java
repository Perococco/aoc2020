package perococco.aoc.day16;

import lombok.NonNull;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

public abstract class Day16Solver extends SmartSolver<Input,Long> {

    @Override
    protected @NonNull Converter<Input> getConverter() {
        return Converter.ALL_LINES.andThen(Input::parse);
    }
}
