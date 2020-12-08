package perococco.aoc.day8;

import lombok.NonNull;
import perococco.aoc.day8.structures.Instruction;
import perococco.aoc.day8.structures.InstructionVisitor;
import perococco.aoc.day8.structures.instruction.Acc;
import perococco.aoc.day8.structures.instruction.Jmp;
import perococco.aoc.day8.structures.instruction.Nop;

public class Part2Mutator implements InstructionVisitor<Instruction> {

    @Override
    public @NonNull Instruction visit(@NonNull Acc acc) {
        return acc;
    }

    @Override
    public @NonNull Instruction visit(@NonNull Nop nop) {
        return new Jmp(nop.argument());
    }

    @Override
    public @NonNull Instruction visit(@NonNull Jmp jmp) {
        return new Nop(jmp.offset());
    }
}
