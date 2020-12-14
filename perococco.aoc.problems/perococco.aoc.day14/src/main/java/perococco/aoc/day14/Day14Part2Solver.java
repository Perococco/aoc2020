package perococco.aoc.day14;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day14.structures.Memory;
import perococco.aoc.day14.structures.MemoryPart2;

public class Day14Part2Solver extends Day14Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day14Part2Solver().createProblem();
    }

    @Override
    protected @NonNull Memory createMemory() {
        return new MemoryPart2();
    }

}
