package perococco.aoc.day12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day12SolverTest {

    public static final String TEST_INPUT = """
            F10
            N3
            F7
            R90
            F11
            """;

    @Test
    public void testPart1() {
        final int actual = new Day12Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(25,actual);
    }
    @Test
    public void testPart2() {
        final int actual = new Day12Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(286,actual);
    }
}
