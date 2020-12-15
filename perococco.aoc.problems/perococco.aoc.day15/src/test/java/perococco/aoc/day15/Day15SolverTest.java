package perococco.aoc.day15;

import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Day15SolverTest {

    public static @NonNull Stream<Arguments> testInputPart1() {
        return Stream.of(
                Arguments.of("0,3,6", 436)
                ,Arguments.of("1,3,2", 1)
                ,Arguments.of("2,1,3", 10)
                ,Arguments.of("1,2,3", 27)
                ,Arguments.of("2,3,1", 78)
                ,Arguments.of("3,2,1", 438)
                ,Arguments.of("3,1,2", 1836)
        );
    }
    public static @NonNull Stream<Arguments> testInputPart2() {
        return Stream.of(
                Arguments.of("0,3,6" ,175594)
                ,Arguments.of("1,3,2",2578)
                ,Arguments.of("2,1,3",3544142)
                ,Arguments.of("1,2,3",261214)
                ,Arguments.of("2,3,1",6895259)
                ,Arguments.of("3,2,1",18)
                ,Arguments.of("3,1,2",362)
        );
    }
    @ParameterizedTest
    @MethodSource("testInputPart1")
    public void testPart1(@NonNull String line, long expected) {
        final long actual = new Day15Part1Solver().createProblem(line).solve();
        Assertions.assertEquals(expected,actual);
    }

    @ParameterizedTest
    @MethodSource("testInputPart2")
    public void testPart2(@NonNull String line, long expected) {
        final long actual = new Day15Part2Solver().createProblem(line).solve();
        Assertions.assertEquals(expected,actual);
    }
}
