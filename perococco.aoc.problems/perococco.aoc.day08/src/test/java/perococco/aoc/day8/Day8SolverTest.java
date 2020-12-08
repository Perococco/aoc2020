package perococco.aoc.day8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day8SolverTest {

    public static final String EXAMPLE_INPUT = """
            nop +0
            acc +1
            jmp +4
            acc +3
            jmp -3
            acc -99
            acc +1
            jmp -4
            acc +6
            """;

    @Test
    void testPart1() {
        final var actual = new Day8Part1Solver().createProblem(EXAMPLE_INPUT).solve();
        Assertions.assertEquals(5, actual);
    }

    @Test
    void testPart2() {
        final var actual = new Day8Part2Solver().createProblem(EXAMPLE_INPUT).solve();
        Assertions.assertEquals(8, actual);
    }
}
