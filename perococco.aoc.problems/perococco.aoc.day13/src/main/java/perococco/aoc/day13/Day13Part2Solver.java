package perococco.aoc.day13;

import lombok.NonNull;
import lombok.Value;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.AOCException;
import perococco.aoc.common.Tools;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day13Part2Solver extends Day13Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day13Part2Solver().createProblem();
    }

    @Override
    public @NonNull BigInteger solve(@NonNull Notes input) {
        final var buses = input.buses();

        if (buses.size() == 1) {
            return BigInteger.ZERO;
        }

        //assume all numbers are primes
        final var product = buses.stream()
                                 .filter(Bus::isRunning)
                                 .map(Bus::id)
                                 .reduce(BigInteger.ONE, BigInteger::multiply);

        // We can write a solution of the problem (that is not the minimal one) like this
        //
        // N = k1.(product/id_1) + k2.(product/id_2) + k3.(product/id_3) + ...
        //
        // then N mod id_i = ki.(product/id_i)  this does not depend on the other ks
        // and can be solved for each bus independently.
        // the minimal solution is then obtain from N by take the modulo of N by 'product'

        return IntStream.range(0, buses.size())
                        .mapToObj(i -> solveForOneBus(buses.get(i), product, i))
                        .reduce(BigInteger.ZERO, BigInteger::add)
                        .mod(product);
    }

    //we use the Fermat's little theorem
    public @NonNull BigInteger solveForOneBus(@NonNull Bus bus, @NonNull BigInteger productOfAllIds, int index) {
        if (bus.isOutOfService()) {
            return BigInteger.ZERO;
        }
        final var id = bus.id();
        final var remaining = index == 0 ? 0 : id.intValue() - index;
        final var productOfOthers = productOfAllIds.divide(id);
        return productOfOthers.pow(id.intValue() - 1).multiply(BigInteger.valueOf(remaining));
    }

}
