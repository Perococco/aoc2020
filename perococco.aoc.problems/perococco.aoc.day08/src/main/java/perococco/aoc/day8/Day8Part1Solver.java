package perococco.aoc.day8;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day8.structures.Processor;
import perococco.aoc.day8.structures.Program;

public class Day8Part1Solver extends Day8Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day8Part1Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull Program program) {
        return Processor.with(new Part1StopCondition())
                        .launch(program)
                        .getResultOrThrow()
                        .accumulator();
    }
}
