package perococco.aoc.day13;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.Tools;

import java.math.BigInteger;

public class Day13Part1Solver extends Day13Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day13Part1Solver().createProblem();
    }

    @Override
    public @NonNull BigInteger solve(@NonNull Notes input) {
        final NextStop nextStop = input.findNextStop();

        return nextStop.busId().multiply(nextStop.waitingTime());
    }
}
