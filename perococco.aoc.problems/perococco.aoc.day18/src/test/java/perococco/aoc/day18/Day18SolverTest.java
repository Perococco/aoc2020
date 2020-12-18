package perococco.aoc.day18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day18SolverTest {

    public static final String TEST_INPUT = """
            """;

    @Test
    public void testPart1() {
        final var actual = new Day18Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(-1,actual);
    }

}
