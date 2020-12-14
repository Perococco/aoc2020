package perococco.aoc.day14;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day14.structures.Memory;
import perococco.aoc.day14.structures.MemoryPart1;

public class Day14Part1Solver extends Day14Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day14Part1Solver().createProblem();
    }

    @Override
    protected @NonNull Memory createMemory() {
        return new MemoryPart1();
    }

}
