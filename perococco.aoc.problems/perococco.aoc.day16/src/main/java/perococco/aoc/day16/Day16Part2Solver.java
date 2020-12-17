package perococco.aoc.day16;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.AOCException;
import perococco.aoc.common.Tools;

import java.util.Map;

public class Day16Part2Solver extends Day16Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day16Part2Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull Input input) {
        final var matcher = new FieldsMatcher(input.fields());

        for (Ticket ticket : input.allTickets()) {
            matcher.testTicket(ticket);
        }

        matcher.cleanUp();

        final var mapping = matcher.getSolution().orElseThrow(() -> new AOCException("Not solved yet!"));

        final var myTicket = input.myTicket();

        return mapping.entrySet()
                      .stream()
                      .filter(e -> e.getKey().nameStartsWith("departure"))
                      .mapToInt(Map.Entry::getValue)
                      .map(myTicket::getValueAt)
                      .mapToLong(i -> i)
                      .reduce(1, (i1, i2) -> i1 * i2);

    }

}
