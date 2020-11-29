package perococco.aoc.launcher._private;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.api.AOCProblemId;
import perococco.aoc.api.Day;
import perococco.aoc.api.Part;
import perococco.aoc.common.AOCException;
import perococco.aoc.common.Tools;

import java.util.Optional;
import java.util.ServiceLoader;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class ProblemService {

    public static Stream<AOCProblem<?>> loadProblems() {
        return ServiceLoader.load(AOCProblem.class)
                            .stream()
                            .map(ServiceLoader.Provider::get)
                            .filter(p -> !p.isSkipped())
                            .map(p -> (AOCProblem<?>) p);
    }


    public static AOCProblem<?> findLastDefinedProblem() {
        return loadProblems()
                .max(AOCProblem::compareTo)
                .orElseThrow(() -> new AOCException("No AOCProgram could be found"));
    }

    @NonNull
    public static Optional<Day> findLastDay() {
        return loadProblems()
                .map(AOCProblem::id)
                .map(AOCProblemId::day)
                .max(Day.DAY_COMPARATOR);
    }

    public static Optional<? extends AOCProblem<?>> findProgramById(@NonNull AOCProblemId id) {
        return loadProblems()
                .filter(p -> id.equals(p.id()))
                .findFirst();
    }

    public static Optional<? extends AOCProblem<?>> findProgramById(@NonNull Day day, @NonNull Part part) {
        return findProgramById(day.createIdWith(part));
    }

    public static Optional<? extends AOCProblem<?>> findProgramById(@NonNull String dayAsString, @NonNull String partAsString) {
        final Day day = Day.parse(dayAsString);
        final Part part = Part.parse(partAsString);
        return findProgramById(day, part);
    }

    public static ImmutableList<? extends AOCProblem<?>> listPrograms(@NonNull Predicate<AOCProblemId> filter) {
        return loadProblems().filter(p -> filter.test(p.id())).collect(ImmutableList.toImmutableList());
    }

    public static ImmutableList<? extends AOCProblem<?>> listProgramsOfADay(@NonNull Day day) {
        return listPrograms(id -> id.day().equals(day));
    }

    public static AOCProblem<?> getProgramById(@NonNull String dayAsString, @NonNull String partAsString) {
        final Day day = Day.parse(dayAsString);
        final Part part = Part.parse(partAsString);
        return getProgramById(day, part);
    }

    public static AOCProblem<?> getProgramById(@NonNull Day day, @NonNull Part part) {
        final AOCProblemId problemId = new AOCProblemId(day, part);
        return findProgramById(day, part).orElseThrow(() -> new AOCException("Could not find a problem with id " + problemId));
    }

}
