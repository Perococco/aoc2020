package perococco.aoc.day6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDay6 {

    private static final String TEST_INPUT_DAY1 = """
            abc
                        
            a
            b
            c
                        
            ab
            ac
                        
            a
            a
            a
            a
                        
            b
            """;

    @Test
    public void testPart1() {
        final int result = new Day6Part1Solver().createProblem(TEST_INPUT_DAY1).solve();
        Assertions.assertEquals(11,result);
    }

    @Test
    public void testPart2() {
        final int result = new Day6Part2Solver().createProblem(TEST_INPUT_DAY1).solve();
        Assertions.assertEquals(6,result);
    }
}
