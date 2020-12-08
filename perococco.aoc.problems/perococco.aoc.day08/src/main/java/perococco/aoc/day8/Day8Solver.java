package perococco.aoc.day8;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.day8.structures.Instruction;
import perococco.aoc.day8.structures.Program;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

public abstract class Day8Solver extends SmartSolver<Program, Integer> {

    @Override
    protected @NonNull Converter<Program> getConverter() {
        return input -> {
            final var code = input.map(Instruction::parse).collect(ImmutableList.toImmutableList());
            return new Program(code);
        };
    }
}
