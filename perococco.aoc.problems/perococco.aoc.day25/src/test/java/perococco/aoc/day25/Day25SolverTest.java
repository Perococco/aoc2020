package perococco.aoc.day25;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day25SolverTest {

    public static final String TEST_INPUT = """
            17807724
            5764801
            """;

    @Test
    public void testPart1() {
        final var actual = new Day25Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(14897079,actual);
    }
}
