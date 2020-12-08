package perococco.aoc.day8.structures;

import lombok.NonNull;

public interface StopCondition {

    boolean shouldStopExecution(@NonNull ExecutionContext executionContext);
}
