package perococco.aoc.day18;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day18.structures.ExpressionEvaluator;
import perococco.aoc.day18.structures.ExpressionEvaluatorPart2;

public class Day18Part2Solver extends Day18Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day18Part2Solver().createProblem();
    }

    @Override
    protected @NonNull ExpressionEvaluator createOnePassEvaluator() {
        return new ExpressionEvaluatorPart2();
    }
}
