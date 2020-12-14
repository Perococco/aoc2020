package perococco.aco.day14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import perococco.aoc.day14.Day14Part1Solver;
import perococco.aoc.day14.Day14Part2Solver;

public class Day14SolverTest {

    public static final String TEST_INPUT_PART1 = """
            mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X
            mem[8] = 11
            mem[7] = 101
            mem[8] = 0
            """;

    public static final String TEST_INPUT_PART2 = """
            mask = 000000000000000000000000000000X1001X
            mem[42] = 100
            mask = 00000000000000000000000000000000X0XX
            mem[26] = 1
            """;

    @Test
    public void testPart1() {
        final var actual = new Day14Part1Solver().createProblem(TEST_INPUT_PART1).solve();
        Assertions.assertEquals(165L,actual);
    }
    @Test
    public void testPart2() {
        final var actual = new Day14Part2Solver().createProblem(TEST_INPUT_PART2).solve();
        Assertions.assertEquals(208L,actual);
    }

}
