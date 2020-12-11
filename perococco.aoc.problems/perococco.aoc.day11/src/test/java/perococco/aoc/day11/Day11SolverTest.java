package perococco.aoc.day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day11SolverTest {

    public static final String EXAMPLE_INPUT = """
            L.LL.LL.LL
            LLLLLLL.LL
            L.L.L..L..
            LLLL.LL.LL
            L.LL.LL.LL
            L.LLLLL.LL
            ..L.L.....
            LLLLLLLLLL
            L.LLLLLL.L
            L.LLLLL.LL
            """;

    @Test
    public void testPart1() {
        final long actual = new Day11Part1Solver().createProblem(EXAMPLE_INPUT).solve();
        Assertions.assertEquals(37L,actual);
    }

    @Test
    public void testPart2() {
        final long actual = new Day11Part2Solver().createProblem(EXAMPLE_INPUT).solve();
        Assertions.assertEquals(26L,actual);
    }
}
