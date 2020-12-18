package perococco.aoc.day17;

import com.google.common.collect.Iterators;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Iterator;
import java.util.stream.Stream;

public class NeighProviderTest {


    public static Stream<Point4D> pointsToTest() {
        return Stream.of(
                Point4D.of(0, 0, 0, 0),
                Point4D.of(0, 0, 0, 1),
                Point4D.of(9, 12, 5, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("pointsToTest")
    public void shouldHave80Neighbours(@NonNull Point4D point) {
        final long nbNeighbours = point.neighbours().count();
        Assertions.assertEquals(80, nbNeighbours);
    }

    @ParameterizedTest
    @MethodSource("pointsToTest")
    public void shouldNotHaveMoreThan2InDiff(@NonNull Point4D point) {
        final Iterator<Point4D> iter = point.neighbours().iterator();
        while (iter.hasNext()) {
            final var p = iter.next();
            Assertions.assertTrue(p.isNeighbourOf(point), p +" is neighbour of "+point);
        }
    }
}
