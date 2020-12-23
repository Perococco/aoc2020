package perococco.aoc.day23;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day23SolverTest {

    public static final String TEST_INPUT = "389125467";

    @Test
    public void testPart1() {
        final var actual = new Day23Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals("67384529",actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day23Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals("149245887792",actual);
    }

    @Test
    public void part1() {
        final var actual = new Day23Part1Solver().createProblem().solve();
        Assertions.assertEquals("27865934",actual);
    }
}
