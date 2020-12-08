package perococco.aoc.day8;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.AOCException;
import perococco.aoc.common.Tools;
import perococco.aoc.day8.structures.*;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day8Part2Solver extends Day8Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day8Part2Solver().createProblem();
    }

    private static final Part2Mutator instructionMutator = new Part2Mutator();

    @Override
    public @NonNull Integer solve(@NonNull Program program) {
        return streamProgramCandidates(program.code())
                .map(this::execute)
                .flatMap(Optional::stream)
                .findFirst()
                .orElseThrow(() -> new AOCException("You are too stupid to solve this"))
                .accumulator();
    }

    private @NonNull Optional<ExecutionContext> execute(Program program) {
        return Processor.with(Part2StopCondition.createFor(program))
                        .launch(program)
                        .getResult();
    }

    private @NonNull Stream<Program> streamProgramCandidates(@NonNull ImmutableList<Instruction> originalCode) {
        return IntStream.range(0, originalCode.size())
                        .filter(i -> originalCode.get(i).getOperation() != Operation.ACC)
                        .mapToObj(i -> alterCode(originalCode, i));
    }

    private @NonNull Program alterCode(
            @NonNull ImmutableList<Instruction> originalCode,
            int alterationIndex) {
        final var alteredCode = Tools.replaceAt(originalCode,alterationIndex,instructionMutator.asFunction());
        return new Program(alteredCode);
    }
}
