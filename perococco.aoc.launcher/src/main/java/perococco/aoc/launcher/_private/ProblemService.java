package perococco.aoc.launcher._private;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.api.AOCProblemId;
import perococco.aoc.api.Day;
import perococco.aoc.api.Part;
import perococco.aoc.common.AOCException;

import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.Stream;


public class ProblemService {

    public static AOCProblem<?> findLastDefinedProblem() {
        return loadProblems()
                .max(AOCProblem::compareTo)
                .orElseThrow(() -> new AOCException("No AOCProgram could be found"));
    }

    @NonNull
    public static Day findLastDay() {
        return loadProblems()
                .map(AOCProblem::id)
                .map(AOCProblemId::day)
                .max(Day.DAY_COMPARATOR)
                .orElseThrow();
    }

    public static Stream<AOCProblem<?>> loadProblems() {
        return ServiceLoader.load(AOCProblem.class)
                            .stream()
                            .map(ServiceLoader.Provider::get)
                            .filter(p -> !p.isSkipped())
                            .map(p -> (AOCProblem<?>) p);
    }

    public static Optional<? extends AOCProblem<?>> findProgramById(@NonNull String dayAsString, @NonNull String partAsString) {
        final Day day = Day.parse(dayAsString);
        final Part part = Part.parse(partAsString);
        return findProgramById(day, part);
    }

    public static Optional<? extends AOCProblem<?>> findProgramById(@NonNull Day day, @NonNull Part part) {
        final AOCProblemId problemId = new AOCProblemId(day, part);

        return loadProblems()
                .filter(p -> p.id().equals(problemId))
                .findFirst();

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
