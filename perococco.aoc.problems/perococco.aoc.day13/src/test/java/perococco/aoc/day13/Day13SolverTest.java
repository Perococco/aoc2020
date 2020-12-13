package perococco.aoc.day13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Day13SolverTest {

    public static final String TEST_INPUT = """
            939
            7,13,x,x,59,x,31,19
            """;

    @Test
    public void testPart1() {
        final var actual = new Day13Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(BigInteger.valueOf(295), actual);
    }

    public static Stream<Arguments> part2TestCases() {
        return Stream.of(
                Arguments.of("7,13,x,x,59,x,31,19", 1068781),
                Arguments.of("17,x,13,19", 3417),
                Arguments.of("67,7,59,61", 754018),
                Arguments.of("67,x,7,59,61", 779210),
                Arguments.of("67,7,x,59,61", 1261476),
                Arguments.of("1789,37,47,1889", 1202161486)
        );
    }

    @ParameterizedTest
    @MethodSource("part2TestCases")
    public void testPart2(String input, long expected) {
        final var actual = new Day13Part2Solver().createProblem(input).solve();
        Assertions.assertEquals(BigInteger.valueOf(expected),actual);
    }

}
