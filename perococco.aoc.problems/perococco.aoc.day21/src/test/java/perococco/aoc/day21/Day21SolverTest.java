package perococco.aoc.day21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day21SolverTest {

    public static final String TEST_INPUT = """
            mxmxvkd kfcds sqjhc nhms (contains dairy, fish)
            trh fvjkl sbzzf mxmxvkd (contains dairy)
            sqjhc fvjkl (contains soy)
            sqjhc mxmxvkd sbzzf (contains fish)
            """;

    @Test
    public void testPart1() {
        final var actual = new Day21Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(5,actual);
    }
    @Test
    public void testPart2() {
        final var actual = new Day21Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals("mxmxvkd,sqjhc,fvjkl",actual);
    }
}
