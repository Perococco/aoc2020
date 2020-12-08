package perococco.aoc.day8.structures;

import lombok.NonNull;
import perococco.aoc.day8.structures.instruction.Acc;
import perococco.aoc.day8.structures.instruction.Jmp;
import perococco.aoc.day8.structures.instruction.Nop;

public interface ComplexInstructionVisitor<P,T> {

    @NonNull T visit(@NonNull Acc acc, @NonNull P parameter);
    @NonNull T visit(@NonNull Nop nop, @NonNull P parameter);
    @NonNull T visit(@NonNull Jmp jmp, @NonNull P parameter);
}
