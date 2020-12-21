package perococco.aoc.day18;

import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import perococco.aoc.day18.structures.ExprEvaluatorTemplate;
import perococco.aoc.day18.structures.ExpressionEvaluatorPart1;
import perococco.aoc.day18.structures.ExpressionEvaluatorPart2;

import java.util.stream.Stream;

public class Day18SolverTest {

    public static Stream<Arguments> expressionTestPart1() {
        return Stream.of(
        Arguments.of("2 * 3 + (4 * 5)", 26),
        Arguments.of("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))",12240),
        Arguments.of("5 + (8 * 3 + 9 + 3 * 4 * 3)", 437),
        Arguments.of("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2", 13632)
        );
    }
    public static Stream<Arguments> expressionTestPart2() {
        return Stream.of(
        Arguments.of("1 + (2 * 3) + (4 * (5 + 6))", 51),
        Arguments.of("2 * 3 + (4 * 5)",46),
        Arguments.of("5 + (8 * 3 + 9 + 3 * 4 * 3)", 1445),
        Arguments.of("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))",669060),
        Arguments.of("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2",23340)
        );
    }


    @ParameterizedTest
    @MethodSource("expressionTestPart1")
    public void testPart1(@NonNull String expression, long expected) {
        final var evaluator = new ExprEvaluatorTemplate(new ExpressionEvaluatorPart1());
        final var actual = evaluator.evaluate(expression);
        Assertions.assertEquals(expected,actual);
    }

    @ParameterizedTest
    @MethodSource("expressionTestPart2")
    public void testPart2(@NonNull String expression, long expected) {
        final var evaluator = new ExprEvaluatorTemplate(new ExpressionEvaluatorPart2());
        final var actual = evaluator.evaluate(expression);
        Assertions.assertEquals(expected,actual);
    }

}
