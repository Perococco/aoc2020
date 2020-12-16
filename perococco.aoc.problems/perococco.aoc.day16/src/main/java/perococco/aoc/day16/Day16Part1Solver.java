package perococco.aoc.day16;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;

public class Day16Part1Solver extends Day16Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day16Part1Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull Input input) {
        final var mask = Mask.create(input.fields());

        return (long)input.streamNearByTickets()
                    .flatMapToInt(Ticket::values)
                    .filter(mask::isNotValid)
                    .sum();
    }
}
