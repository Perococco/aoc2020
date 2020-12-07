package perococco.aoc.day5;

import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import perococco.aoc.day5.structures.Seat;

import java.util.stream.Stream;

public class Day5Test {

    public static Stream<Arguments> part1TestSample() {
        return Stream.of(
                Arguments.of("BFFFBBFRRR",567),
                Arguments.of("FFFBBBFRRR",119),
                Arguments.of("BBFFBBFRLL",820)
        );
    }

    @ParameterizedTest
    @MethodSource("part1TestSample")
    public void testExamplePart1(@NonNull String boardingPassId, int expectedSeatId) {
        final Seat seat = Seat.of(boardingPassId);
        Assertions.assertEquals(expectedSeatId,seat.id());
    }


}
