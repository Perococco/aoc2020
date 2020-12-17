package perococco.aoc.day16;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import lombok.*;
import perococco.aoc.common.AOCException;

import java.util.function.Consumer;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Builder
public class Input {

    @Singular
    @Getter
    private final @NonNull ImmutableSet<Field> fields;
    @Singular
    private final @NonNull ImmutableList<Ticket> tickets;


    public @NonNull ImmutableList<Ticket> allTickets() {
        return tickets;
    }

    public @NonNull Ticket myTicket() {
        return tickets.get(0);
    }

    public int numberOfFields() {
        return fields.size();
    }

    public @NonNull Stream<Ticket> streamNearByTickets() {
        return tickets.stream().skip(1);
    }

    public static @NonNull Input parse(@NonNull ImmutableList<String> lines) {
        final var builder = Input.builder();

        Consumer<String> parser = l -> builder.field(Field.parse(l));
        for (int i = 0, linesSize = lines.size(); i < linesSize; i++) {
            String line = lines.get(i);
            if (line.isBlank()) {
                parser = null;
            } else if (line.equals("your ticket:")) {
                parser = l -> builder.ticket(Ticket.parse(l));
            } else if (line.equals("nearby tickets:")) {
                parser = l -> builder.ticket(Ticket.parse(l));
            } else if (parser == null) {
                throw new AOCException("No parser available for line #" + i + "'" + line + "'");
            } else {
                parser.accept(line);
            }
        }

        return builder.build();
    }

}
