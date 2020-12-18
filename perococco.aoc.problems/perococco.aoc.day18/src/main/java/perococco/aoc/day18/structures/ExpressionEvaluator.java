package perococco.aoc.day18.structures;

import lombok.NonNull;

import java.util.Deque;

public interface ExpressionEvaluator {

    boolean performOnePass(@NonNull Deque<Token> tokens);

    long getFinalResultFromQueue(@NonNull Deque<Token> tokens);
}
