package perococco.aoc.day8;

import lombok.NonNull;
import perococco.aoc.day8.structures.ExecutionContext;
import perococco.aoc.day8.structures.StopCondition;

import java.util.HashSet;
import java.util.Set;

public class Part1StopCondition implements StopCondition {

    private final Set<Integer> positionExecuted = new HashSet<>();

    @Override
    public boolean shouldStopExecution(@NonNull ExecutionContext executionContext) {
        if (positionExecuted.contains(executionContext.pointer())) {
            return true;
        }
        positionExecuted.add(executionContext.pointer());
        return false;
    }
}
