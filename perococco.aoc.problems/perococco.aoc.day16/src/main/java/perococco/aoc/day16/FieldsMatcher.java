package perococco.aoc.day16;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import lombok.NonNull;
import perococco.aoc.common.AOCException;
import perococco.aoc.common.Tools;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FieldsMatcher {

    private final @NonNull ImmutableSet<Field> fields;

    private final @NonNull Mask mask;

    private final @NonNull Map<Field, Set<Integer>> matchingPositions;

    private final int numberOfFields;

    public FieldsMatcher(ImmutableSet<Field> allFields) {
        this.mask = Mask.create(allFields);
        this.fields = allFields;
        this.numberOfFields = allFields.size();
        this.matchingPositions = allFields.stream()
                                          .collect(Collectors.toMap(f -> f, f -> allPositions(numberOfFields)));
    }

    private static Set<Integer> allPositions(int numberOfFields) {
        return IntStream.range(0, numberOfFields).boxed().collect(Collectors.toSet());
    }

    public void testTicket(@NonNull Ticket ticket) {
        if (!mask.isValid(ticket)) {
            return;
        }
        for (int position = 0; position < numberOfFields; position++) {
            final var value = ticket.getValueAt(position);
            for (Field field : fields) {
                final var matchingPosition = matchingPositions.get(field);
                if (!field.isValid(value)) {
                    matchingPosition.remove(position);
                }
                if (matchingPosition.isEmpty()) {
                    throw new AOCException("No field associated with position " + position + " for value " + value);
                }
            }

        }
    }

    public @NonNull Optional<ImmutableMap<Field, Integer>> getSolution() {
        final var builder = ImmutableMap.<Field, Integer>builder();
        for (Field field : matchingPositions.keySet()) {
            final var matchingPosition = matchingPositions.get(field);
            if (matchingPosition.size() != 1) {
                return Optional.empty();
            }
            builder.put(field, Tools.getOneElement(matchingPosition));
        }
        return Optional.of(builder.build());
    }

    public void cleanUp() {
        Set<Field> fieldToCheck = getInitialFieldsToCheck();
        while (!fieldToCheck.isEmpty()) {
            fieldToCheck = cleanUp(fieldToCheck);
        }
    }

    private @NonNull Set<Field> getInitialFieldsToCheck() {
        return matchingPositions.keySet()
                                .stream()
                                .filter(f -> matchingPositions.get(f).size() == 1)
                                .collect(Collectors.toSet());
    }

    private Set<Field> cleanUp(@NonNull Set<Field> fieldToCheck) {
        final Set<Field> changedFields = new HashSet<>();
        for (Field field : fieldToCheck) {
            final var matchingPosition = matchingPositions.get(field);
            if (matchingPosition.size() > 1) {
                continue;
            }
            final int resolvedPosition = Tools.getOneElement(matchingPosition);
            removeOnePosition(field, resolvedPosition, changedFields);
        }
        return changedFields;
    }

    private void removeOnePosition(@NonNull Field fieldToSkip, int positionToRemove, @NonNull Set<Field> changedFields) {
        for (var fieldSetEntry : matchingPositions.entrySet()) {
            final var field = fieldSetEntry.getKey();
            final var positions = fieldSetEntry.getValue();
            if (field.equals(fieldToSkip)) {
                continue;
            }
            if (positions.remove(positionToRemove)) {
                if (positions.size() == 1) {
                    changedFields.add(field);
                }
            }
        }
    }


}
