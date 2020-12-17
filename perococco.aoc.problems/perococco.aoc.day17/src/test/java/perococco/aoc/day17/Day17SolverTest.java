package perococco.aoc.day17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day17SolverTest {

    public static final String TEST_INPUT = """
             .#.
             ..#
             ###
             """;

    @Test
    public void testPart1() {
        final long actual = new Day17Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(112,actual);
    }

    @Test
    public void testPart2() {
        final long actual = new Day17Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(848,actual);
    }
}
