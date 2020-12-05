package perococco.aoc.day5;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day5.structures.BoardingPass;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day5Solver<O> extends SmartSolver<Stream<BoardingPass>,O> {

    @Override
    protected @NonNull Converter<Stream<BoardingPass>> getConverter() {
        return s -> s.map(BoardingPass::create);
    }

}
