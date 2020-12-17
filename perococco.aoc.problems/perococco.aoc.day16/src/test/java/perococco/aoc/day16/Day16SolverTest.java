package perococco.aoc.day16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day16SolverTest {

    public static final String TEST_INPUT = """
            class: 1-3 or 5-7
            row: 6-11 or 33-44
            seat: 13-40 or 45-50
                        
            your ticket:
            7,1,14
                        
            nearby tickets:
            7,3,47
            40,4,50
            55,2,20
            38,6,12
            """;

    @Test
    public void testPart1() {
        final var actual = new Day16Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(71,actual);
    }
}
