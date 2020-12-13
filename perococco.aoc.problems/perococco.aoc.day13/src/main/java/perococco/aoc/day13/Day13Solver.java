package perococco.aoc.day13;

import lombok.NonNull;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.math.BigInteger;

public abstract class Day13Solver extends SmartSolver<Notes, BigInteger> {

    @Override
    protected @NonNull Converter<Notes> getConverter() {
        return Converter.ALL_LINES.andThen(Notes::parse);
    }

}
