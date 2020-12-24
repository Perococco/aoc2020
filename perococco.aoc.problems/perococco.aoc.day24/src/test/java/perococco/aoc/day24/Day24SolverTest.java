package perococco.aoc.day24;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day24SolverTest {

    public static final String TEST_INPUT = """
            sesenwnenenewseeswwswswwnenewsewsw
            neeenesenwnwwswnenewnwwsewnenwseswesw
            seswneswswsenwwnwse
            nwnwneseeswswnenewneswwnewseswneseene
            swweswneswnenwsewnwneneseenw
            eesenwseswswnenwswnwnwsewwnwsene
            sewnenenenesenwsewnenwwwse
            wenwwweseeeweswwwnwwe
            wsweesenenewnwwnwsenewsenwwsesesenwne
            neeswseenwwswnwswswnw
            nenwswwsewswnenenewsenwsenwnesesenew
            enewnwewneswsewnwswenweswnenwsenwsw
            sweneswneswneneenwnewenewwneswswnese
            swwesenesewenwneswnwwneseswwne
            enesenwswwswneneswsenwnewswseenwsese
            wnwnesenesenenwwnenwsewesewsesesew
            nenewswnwewswnenesenwnesewesw
            eneswnwswnwsenenwnwnwwseeswneewsenese
            neswnwewnwnwseenwseesewsenwsweewe
            wseweeenwnesenwwwswnew
            """;

    @Test
    public void testPart1() {
        final var actual = new Day24Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(10,actual);
    }
    @Test
    public void testPart2() {
        final var actual = new Day24Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(2208,actual);
    }
}
