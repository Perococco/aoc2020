package perococco.aoc.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class TestDay1Part2Solver {

    @Test
    void testExample() {
        final Day1Part2Solver solver = new Day1Part2Solver();
        final long result = solver.solve(IntStream.of(
                1721,
                979,
                366,
                299,
                675,
                1456
        ));
        Assertions.assertEquals(241861950,result);
    }
}
