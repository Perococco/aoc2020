package perococco.aoc.day16;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import lombok.NonNull;
import perococco.aoc.common.AOCException;

import java.util.*;

public class FieldsMatcher {

    private final @NonNull ImmutableSet<Field> fields;

    private final @NonNull Mask mask;

    private final @NonNull List<Set<Field>> matchByPositions;

    private final int numberOfFields;

    public FieldsMatcher(ImmutableSet<Field> allFields) {
        this.mask = Mask.create(allFields);
        this.fields = allFields;
        this.numberOfFields = allFields.size();
        this.matchByPositions = new ArrayList<>(numberOfFields);
        for (int i = 0; i < numberOfFields; i++) {
            this.matchByPositions.add(new HashSet<>(allFields));
        }
    }

    public void testTicket(@NonNull Ticket ticket) {
        if (!mask.isValid(ticket)) {
            return;
        }
        for (Field field : fields) {
            for (int i = 0; i < numberOfFields; i++) {
                final var value = ticket.getValueAt(i);
                final var matchingFields = matchByPositions.get(i);
                if (!field.isValid(value)) {
                    matchingFields.remove(field);
                }
                if (matchingFields.isEmpty()) {
                    throw new AOCException("No field associated with position "+i+" for value "+value);
                }
            }
        }
    }


    public @NonNull Optional<ImmutableMap<Field,Integer>> getSolution() {
        final var builder = ImmutableMap.<Field,Integer>builder();
        for (int i = 0; i < numberOfFields; i++) {
            final var matchingFields = matchByPositions.get(i);
            if (matchingFields.size() != 1) {
                return Optional.empty();
            }
            builder.put(matchingFields.iterator().next(),i);
        }
        return Optional.ofNullable(builder.build());
    }

    public void cleanUp() {
        while (doCleanUp());
    }

    private boolean doCleanUp() {
        boolean removed = false;
        for (int i = 0; i < numberOfFields; i++) {
            final var matchingFields = matchByPositions.get(i);
            if (matchingFields.size() == 1) {
                final Field field = matchingFields.iterator().next();
                for (int j = 0; j < numberOfFields; j++) {
                    if (j != i) {
                        removed |= matchByPositions.get(j).remove(field);
                    }
                }
            }
        }
        return removed;
    }

}
