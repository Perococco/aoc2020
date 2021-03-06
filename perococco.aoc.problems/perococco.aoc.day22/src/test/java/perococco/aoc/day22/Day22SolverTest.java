package perococco.aoc.day22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import perococco.aoc.day22.structures.Score;

public class Day22SolverTest {

    public static final String TEST_INPUT = """
            Player 1:
            9
            2
            6
            3
            1
                        
            Player 2:
            5
            8
            4
            7
            10
            """;

    public static final String INFINITE_LOOP = """
            Player 1:
            43
            19
                        
            Player 2:
            2
            29
            14
            """;

    @Test
    public void testPart1() {
        final var actual = new Day22Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(Score.of(306), actual);
    }

    @Test
    @Timeout(value = 1)
    public void testInfiniteLoop() {
        final var actual = new Day22Part2Solver().createProblem(INFINITE_LOOP).solve();
    }

    @Test
    public void testPart2() {
        final var actual = new Day22Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(Score.of(291),actual);
    }

    @Test
    public void testPart1WithRealInput() {
        final var actual = new Day22Part1Solver().createProblem().solve();
        Assertions.assertEquals(Score.of(33421),actual);
    }

    @Test
    public void testPart2WithRealInput() {
        final var actual = new Day22Part2Solver().createProblem().solve();
        Assertions.assertEquals(Score.of(33651),actual);
    }


}
