package perococco.aoc.day13;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.common.Tools;

import java.math.BigInteger;

public class Part2IncrementalSolver implements Part2Solver {

    @Override
    public @NonNull BigInteger solve(@NonNull ImmutableList<Bus> buses) {
        var factor = BigInteger.ONE;
        var timeStamp = BigInteger.ZERO;
        for (int i = 0; i < buses.size(); i++) {
            var bus = buses.get(i);
            if (bus.isOutOfService()) {
                continue;
            }
            var busId = bus.id().intValue();
            int targetRemain = Tools.mod(busId-i, busId);
            while(timeStamp.mod(bus.id()).intValue() != targetRemain) {
                timeStamp = timeStamp.add(factor);
            }
            factor = factor.multiply(bus.id());
        }
        return timeStamp;

    }
}
