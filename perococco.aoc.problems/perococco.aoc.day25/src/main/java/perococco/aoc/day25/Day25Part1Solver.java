package perococco.aoc.day25;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.stream.Stream;

public class Day25Part1Solver extends Day25Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day25Part1Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull Day25Input input) {
        final PublicKeys k = new PublicKeys(20201227);
        final int doorLoopSize = k.powerOf(input.doorPublicKey());
        final int cardLoopSize = k.powerOf(input.cardPublicKey());


        final var seven = BigInteger.valueOf(7);
        final var modulo = BigInteger.valueOf(20201227);

        return BigInteger.valueOf(input.cardPublicKey()).modPow(BigInteger.valueOf(doorLoopSize),modulo).mod(modulo).longValue();

    }
    
    private static class PublicKeys {
        
        private final int[] valueToPower;

        private final int modulo;

        public PublicKeys(int modulo) {
            this.valueToPower = new int[modulo];
            this.modulo = modulo;
            int v = 1;
            for (int i = 0; i < modulo - 1; i++) {
                valueToPower[v-1] = i;
                v=(v*7)%modulo;
            }
        }

        public int powerOf(int v) {
            return valueToPower[(v%modulo)-1];
        }
    }
}
