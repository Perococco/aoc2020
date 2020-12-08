package perococco.aoc.day8.structures;

import lombok.NonNull;
import perococco.aoc.common.AOCException;

public interface Instruction {

    <P,T> @NonNull T accept(@NonNull ComplexInstructionVisitor<P,T> visitor, @NonNull P parameter);
    <T> @NonNull T accept(@NonNull InstructionVisitor<T> visitor);

    static @NonNull Instruction parse(@NonNull String line) {
        try {
            final String[] token = line.split(" ",2);
            final Operation operation = Operation.find(token[0]);
            return operation.createInstruction(token[1]);
        } catch (Exception e) {
            throw new AOCException("Cannot parse instruction from line '"+line+"'",e);
        }
    }

    @NonNull Operation getOperation();
}

