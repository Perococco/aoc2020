package perococco.aoc.day20;

import org.junit.jupiter.api.Assertions;
import perococco.aoc.common.Tools;

import static perococco.aoc.common.Tools.TODO;

public class Day20SolverTest {

    public static final String TEST_INPUT = """
            """;

    public void testPart1() {
        final var actual = new Day20Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(TODO(), actual);
    }
}
