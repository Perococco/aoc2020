package perococco.aoc.day25;

import lombok.NonNull;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

public abstract class Day25Solver extends SmartSolver<Day25Input,Long> {

    @Override
    protected @NonNull Converter<Day25Input> getConverter() {
        return Converter.ALL_LINES.andThen(Day25Input::parse);
    }
}
