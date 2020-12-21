package perococco.aoc.day20;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.day20.structures.ImageTile;
import perococco.aoc.day20.structures.OrientedImageTitle;
import perococco.aoc.day20.structures.Parser;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day20Solver extends SmartSolver<ImmutableList<ImageTile>,Long> {

    @Override
    protected @NonNull Converter<ImmutableList<ImageTile>> getConverter() {
        return Converter.ALL_LINES.andThen(Parser::parse);
    }

}
