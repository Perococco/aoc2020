package perococco.aoc.day13;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;

import java.math.BigInteger;

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

        final Part2Solver solver1 = new Part2FermatSolver();
        final Part2Solver solver2 = new Part2IncrementalSolver();

        final var solution1 = solver1.solve(buses);
        final var solution2 = solver2.solve(buses);

        assert solution1.equals(solution2);

        return solution1;
    }

}
