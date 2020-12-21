package perococco.aoc.day14;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.day14.structures.Instruction;
import perococco.aoc.day14.structures.Memory;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

public abstract class Day14Solver extends SmartSolver<ImmutableList<Instruction>,Long> {

    @Override
    protected @NonNull Converter<ImmutableList<Instruction>> getConverter() {
        return s -> s.map(Instruction::parse).collect(ImmutableList.toImmutableList());
    }

    protected abstract @NonNull Memory createMemory();

    @Override
    public final @NonNull Long solve(@NonNull ImmutableList<Instruction> input) {
        final Memory memory = createMemory();
        input.forEach(i -> i.applyToMemory(memory));
        return memory.sumOfAllValues();
    }

}
