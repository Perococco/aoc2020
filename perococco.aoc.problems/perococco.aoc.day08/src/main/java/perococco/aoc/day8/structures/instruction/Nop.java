package perococco.aoc.day8.structures.instruction;

import lombok.NonNull;
import lombok.Value;
import perococco.aoc.day8.structures.ComplexInstructionVisitor;
import perococco.aoc.day8.structures.Instruction;
import perococco.aoc.day8.structures.InstructionVisitor;
import perococco.aoc.day8.structures.Operation;

@Value
public class Nop implements Instruction {

    public static Nop parse(@NonNull String argument) {
        return new Nop(Integer.parseInt(argument));
    }

    int argument;

    @Override
    public <P,T> T accept(@NonNull ComplexInstructionVisitor<P,T> visitor, @NonNull P parameter) {
        return visitor.visit(this,parameter);
    }

    @Override
    public <T> @NonNull T accept(@NonNull InstructionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public @NonNull Operation getOperation() {
        return Operation.NOP;
    }
}
