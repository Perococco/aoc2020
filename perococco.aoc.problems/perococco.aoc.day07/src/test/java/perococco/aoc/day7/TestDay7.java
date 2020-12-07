package perococco.aoc.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDay7 {

    public static final String EXAMPLE_INPUT = """
            light red bags contain 1 bright white bag, 2 muted yellow bags.
            dark orange bags contain 3 bright white bags, 4 muted yellow bags.
            bright white bags contain 1 shiny gold bag.
            muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
            shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
            dark olive bags contain 3 faded blue bags, 4 dotted black bags.
            vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
            faded blue bags contain no other bags.
            dotted black bags contain no other bags.
            """;

    public static final String EXAMPLE_INPUT2 = """
            shiny gold bags contain 2 dark red bags.
            dark red bags contain 2 dark orange bags.
            dark orange bags contain 2 dark yellow bags.
            dark yellow bags contain 2 dark green bags.
            dark green bags contain 2 dark blue bags.
            dark blue bags contain 2 dark violet bags.
            dark violet bags contain no other bags.
            """;

    @Test
    public void testPart1() {
        final var actual = new Day7Part1Solver().createProblem(EXAMPLE_INPUT).solve();
        Assertions.assertEquals(4,actual);
    }

    @Test
    public void testPart2a() {
        final var actual = new Day7Part2Solver().createProblem(EXAMPLE_INPUT).solve();
        Assertions.assertEquals(32,actual);
    }
    @Test
    public void testPart2b() {
        final var actual = new Day7Part2Solver().createProblem(EXAMPLE_INPUT2).solve();
        Assertions.assertEquals(126,actual);
    }


}
