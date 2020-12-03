package perococco.oac.day3;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import perococco.aoc.day3.Day3Part1Solver;
import perococco.aoc.day3.Day3Part2Solver;

public class Day3Test {

    private static final ImmutableList<String> EXAMPLE_INPUT = ImmutableList.of(
            "..##.......",
            "#...#...#..",
            ".#....#..#.",
            "..#.#...#.#",
            ".#...##..#.",
            "..#.##.....",
            ".#.#.#....#",
            ".#........#",
            "#.##...#...",
            "#...##....#",
            ".#..#...#.#");

    @Test
    public void testExamplePart1() {
        final long result = new Day3Part1Solver()
                .createProblem(EXAMPLE_INPUT)
                .solve();
        Assertions.assertEquals(7,result);
    }

    @Test
    public void testExamplePart2() {
        final long result = new Day3Part2Solver()
                .createProblem(EXAMPLE_INPUT)
                .solve();
        Assertions.assertEquals(336,result);
    }


}
