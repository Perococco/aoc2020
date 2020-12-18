package perococco.aoc.day18;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day18.structures.ExpressionEvaluator;
import perococco.aoc.day18.structures.ExpressionEvaluatorPart1;

public class Day18Part1Solver extends Day18Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day18Part1Solver().createProblem();
    }

    @Override
    protected @NonNull ExpressionEvaluator createOnePassEvaluator() {
        return new ExpressionEvaluatorPart1();
    }
}
