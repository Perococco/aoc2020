package perococco.aoc.day8.structures.instruction;

import lombok.NonNull;
import perococco.aoc.day8.structures.ComplexInstructionVisitor;
import perococco.aoc.day8.structures.ExecutionContext;

public class InstructionExecutor implements ComplexInstructionVisitor<ExecutionContext, ExecutionContext> {

    @Override
    public @NonNull ExecutionContext visit(@NonNull Acc acc, @NonNull ExecutionContext parameter) {
        return parameter.addToAccumulator(acc.increment()).moveBy(1);
    }

    @Override
    public @NonNull ExecutionContext visit(@NonNull Nop nop, @NonNull ExecutionContext parameter) {
        return parameter.moveBy(1);
    }

    @Override
    public @NonNull ExecutionContext visit(@NonNull Jmp jmp, @NonNull ExecutionContext parameter) {
        return parameter.moveBy(jmp.offset());
    }
}
