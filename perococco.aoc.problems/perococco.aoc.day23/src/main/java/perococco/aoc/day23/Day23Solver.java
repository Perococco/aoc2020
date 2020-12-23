package perococco.aoc.day23;

import lombok.NonNull;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

public abstract class Day23Solver extends SmartSolver<String, String> {

    @Override
    protected @NonNull Converter<String> getConverter() {
        return Converter.FIRST_LINE;
    }

}
