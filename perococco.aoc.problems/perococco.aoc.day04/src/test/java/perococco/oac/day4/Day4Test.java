package perococco.oac.day4;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import perococco.aoc.day4.Day4Part1Solver;
import perococco.aoc.day4.Day4Part2Solver;

public class Day4Test {

    private static final ImmutableList<String> EXAMPLE_INPUT = ImmutableList.of(
            ""
    );

    @Test
    public void testExamplePart1() {
        final long result = new Day4Part1Solver()
                .createProblem(EXAMPLE_INPUT)
                .solve();
        Assertions.assertEquals(0,result);
    }

    @Test
    public void testExamplePart2() {
        final long result = new Day4Part2Solver()
                .createProblem(EXAMPLE_INPUT)
                .solve();
        Assertions.assertEquals(0,result);
    }


}
