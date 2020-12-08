package perococco.aoc.day8.structures;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.AOCException;
import perococco.aoc.day8.structures.instruction.Acc;
import perococco.aoc.day8.structures.instruction.Jmp;
import perococco.aoc.day8.structures.instruction.Nop;

import java.util.Arrays;
import java.util.function.Function;

@RequiredArgsConstructor
public enum Operation {
    ACC(Acc::parse),
    NOP(Nop::parse),
    JMP(Jmp::parse),
    ;

    private final Function<? super String, ? extends Instruction> factory;

    public static @NonNull Operation find(@NonNull String name) {
        final var operation = Holder.OPERATION_BY_NAME.get(name.toLowerCase());
        if (operation == null) {
            throw new AOCException("No operation found with name '" + name + "'");
        }
        return operation;
    }

    public @NonNull Instruction createInstruction(@NonNull String argument) {
        return factory.apply(argument);
    }

    private static class Holder {

        private static final ImmutableMap<String, Operation> OPERATION_BY_NAME;

        static {
            OPERATION_BY_NAME = Arrays.stream(values())
                                      .collect(ImmutableMap.toImmutableMap(op -> op.name().toLowerCase(), op -> op));
        }

    }

}
