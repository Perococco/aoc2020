package perococco.aoc.day8.structures;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.AOCException;
import perococco.aoc.common.TryResult;
import perococco.aoc.day8.structures.instruction.InstructionExecutor;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class Processor {

    public static @NonNull Processor with(@NonNull StopCondition stopCondition) {
        return new Processor(stopCondition);
    }

    private final @NonNull InstructionExecutor executor = new InstructionExecutor();

    private final @NonNull StopCondition stopCondition;

    public TryResult<AOCException,ExecutionContext> launch(@NonNull Program program) {
        final Set<Integer> positionExecuted = new HashSet<>();
        var context = ExecutionContext.createInitial();
        while(true) {
            if (stopCondition.shouldStopExecution(context)) {
                return TryResult.success(context);
            }
            if (positionExecuted.contains(context.pointer())) {
                return TryResult.failure(new AOCException("Cyclic program : "+context.pointer()));
            }
            positionExecuted.add(context.pointer());

            final Instruction current = program.getInstructionAt(context.pointer());
            context = current.accept(executor,context);
        }
    }

}
