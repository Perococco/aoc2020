package perococco.aoc.day18;

import lombok.NonNull;
import perococco.aoc.day18.structures.ExprEvaluatorTemplate;
import perococco.aoc.day18.structures.ExpressionEvaluator;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day18Solver extends SmartSolver<Stream<String>, Long> {

    @Override
    protected @NonNull Converter<Stream<String>> getConverter() {
        return s -> s;
    }

    protected abstract @NonNull ExpressionEvaluator createOnePassEvaluator();

    @Override
    public @NonNull Long solve(@NonNull Stream<String> input) {
        final var evaluator = new ExprEvaluatorTemplate(createOnePassEvaluator());
        return input.mapToLong(evaluator::evaluate)
                    .sum();
    }

}
