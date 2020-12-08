package perococco.aoc.day8;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.day8.structures.ExecutionContext;
import perococco.aoc.day8.structures.Program;
import perococco.aoc.day8.structures.StopCondition;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class Part2StopCondition implements StopCondition {

    public static @NonNull Part2StopCondition createFor(@NonNull Program program) {
        return new Part2StopCondition(program.codeSize());
    }

    private final int codeSize;

    @Override
    public boolean shouldStopExecution(@NonNull ExecutionContext executionContext) {
        return executionContext.pointer()>=codeSize;
    }
}
