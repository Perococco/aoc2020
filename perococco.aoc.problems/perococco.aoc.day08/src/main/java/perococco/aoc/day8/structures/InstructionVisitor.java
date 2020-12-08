package perococco.aoc.day8.structures;

import lombok.NonNull;
import perococco.aoc.day8.structures.instruction.Acc;
import perococco.aoc.day8.structures.instruction.Jmp;
import perococco.aoc.day8.structures.instruction.Nop;

import java.util.function.Function;

public interface InstructionVisitor<T> {

    @NonNull T visit(@NonNull Acc acc);
    @NonNull T visit(@NonNull Nop nop);
    @NonNull T visit(@NonNull Jmp jmp);

    default @NonNull Function<Instruction, T> asFunction() {
        return instruction -> instruction.accept(this);
    }
}
