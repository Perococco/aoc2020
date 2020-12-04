package perococco.aoc.day5;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day5Test {

    private static final ImmutableList<String> EXAMPLE_INPUT_PART = ImmutableList.of(
            ""
    );

    @Test
    public void testExamplePart1() {
        final long result = new Day5Part1Solver()
                .createProblem(EXAMPLE_INPUT_PART)
                .solve();
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testExamplePart2() {
        final long result = new Day5Part2Solver()
                .createProblem(EXAMPLE_INPUT_PART)
                .solve();
        Assertions.assertEquals(0, result);
    }

}
