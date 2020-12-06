package perococco.aoc.day6.structures;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.common.AOCException;
import perococco.aoc.common.Tools;

public class GroupBuilder {

    private final @NonNull ImmutableList.Builder<Person> personBuilder = ImmutableList.builder();

    public void addLine(@NonNull String line) {
        if (line.isBlank()) {
            throw new AOCException("Invalid blank line while building a group");
        }
        final var questions = line.chars()
                                  .mapToObj(Question::parse)
                                  .collect(Tools.enumSetCollector(Question.class));
        personBuilder.add(new Person(questions));
    }

    public @NonNull Group build() {
        return new Group(personBuilder.build());
    }
}
