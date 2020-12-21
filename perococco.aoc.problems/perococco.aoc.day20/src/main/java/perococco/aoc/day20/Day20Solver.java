package perococco.aoc.day20;

import lombok.NonNull;
import perococco.aoc.day20.structures.ImageArray;
import perococco.aoc.day20.structures.ImageArrayBuilder;
import perococco.aoc.day20.structures.Parser;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

public abstract class Day20Solver extends SmartSolver<ImageArray,Long> {

    @Override
    protected @NonNull Converter<ImageArray> getConverter() {
        return Converter.ALL_LINES.andThen(Parser::parse).andThen(ImageArrayBuilder::build);
    }

}
