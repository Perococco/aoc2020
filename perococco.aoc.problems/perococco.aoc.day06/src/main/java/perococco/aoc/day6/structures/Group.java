package perococco.aoc.day6.structures;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import perococco.aoc.common.LazyInt;

import java.util.EnumSet;

@RequiredArgsConstructor
@ToString
public class Group {

    private final @NonNull ImmutableList<Person> people;

    private final LazyInt numberOfDistinctQuestions = new LazyInt(this::countDistinctQuestions);
    private final LazyInt numberOfCommonQuestions = new LazyInt(this::countCommonQuestions);

    public static GroupBuilder builder() {
        return new GroupBuilder();
    }

    public int getNumberOfDistinctQuestions() {
        return numberOfDistinctQuestions.intValue();
    }

    public int getNumberOfCommonQuestions() {
        return numberOfCommonQuestions.intValue();
    }

    private int countDistinctQuestions() {
        return Math.toIntExact(people.stream()
                     .flatMap(Person::questionStream)
                     .distinct()
                     .count());
    }

    private int countCommonQuestions() {
        if (people.size() == 0) {
            return 0;
        }
        final EnumSet<Question> common = EnumSet.allOf(Question.class);
        for (Person person : people) {
            common.removeIf(person::doesNotHaveTheQuestion);
        }

        return common.size();
    }

}
