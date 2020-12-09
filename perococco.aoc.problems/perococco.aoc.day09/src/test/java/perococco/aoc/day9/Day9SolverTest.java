package perococco.aoc.day9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day9SolverTest {

    public static final String PART1_INPUT = """
            35
            20
            15
            25
            47
            40
            62
            55
            65
            95
            102
            117
            150
            182
            127
            219
            299
            277
            309
            576
            """;

    @Test
    public void testPart1() {
        final long actual = new Day9Part1Solver(5).createProblem(PART1_INPUT).solve();
        Assertions.assertEquals(127,actual);
    }
    @Test
    public void testPart2() {
        final long actual = new Day9Part2Solver(5).createProblem(PART1_INPUT).solve();
        Assertions.assertEquals(62,actual);
    }
}
