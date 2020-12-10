package perococco.aoc.day10;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day10.structures.LinearCounter;
import perococco.aoc.day10.structures.Part2Counter;
import perococco.aoc.day10.structures.RecursiveCounter;

@RequiredArgsConstructor
public class Day10Part2Solver extends Day10Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day10Part2Solver().createProblem();
    }

    public final boolean useLinear;

    public Day10Part2Solver() {
        this(true);
    }

    @Override
    public @NonNull Long solve(int @NonNull [] input) {
        final Part2Counter counter = useLinear?new LinearCounter():new RecursiveCounter();
        return counter.count(input);
    }

}




