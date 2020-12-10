package perococco.aoc.day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day10Test {

    public static final String TEST_INPUT_1 = """
            16
            10
            15
            5
            1
            11
            7
            19
            6
            12
            4
            """;
    public static final String TEST_INPUT_2 = """
            28
            33
            18
            42
            31
            14
            46
            20
            48
            47
            24
            23
            49
            45
            19
            38
            39
            11
            1
            32
            25
            35
            8
            17
            7
            9
            4
            2
            34
            10
            3
            """;

    @Test
    public void testPart1_Input1() {
        final long actual = new Day10Part1Solver().createProblem(TEST_INPUT_1).solve();
        Assertions.assertEquals(7*5,actual);
    }

    @Test
    public void testPart1_Input2() {
        final long actual = new Day10Part1Solver().createProblem(TEST_INPUT_2).solve();
        Assertions.assertEquals(22*10,actual);
    }

    @Test
    public void testPart2_Input1() {
        final long actual = new Day10Part2Solver().createProblem(TEST_INPUT_1).solve();
        Assertions.assertEquals(8,actual);
    }

    @Test
    public void testPart2_Input2() {
        final long actual = new Day10Part2Solver().createProblem(TEST_INPUT_2).solve();
        Assertions.assertEquals(19208,actual);
    }

    @Test
    public void testPart2_Input3() {
        final long actual = new Day10Part2Solver().createProblem().solve();
        Assertions.assertEquals(37024595836928L,actual);
    }


}
