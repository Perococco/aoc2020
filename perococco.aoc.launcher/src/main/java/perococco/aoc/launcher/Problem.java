package perococco.aoc.launcher;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.api.AOCProblemId;
import perococco.aoc.api.Day;
import perococco.aoc.api.Part;
import perococco.aoc.common.AOCException;
import perococco.aoc.launcher._private.ProblemService;

import static perococco.aoc.launcher._private.ProblemService.findLastDefinedProblem;
import static perococco.aoc.launcher._private.ProblemService.getProblemById;

public class Problem implements AOCProblem<Object> {

    private final AOCProblem<?> found;

    public Problem(@NonNull String[] args) {
        switch (args.length) {
            case 0 -> found = findLastDefinedProblem();
            case 2 -> found = ProblemService.getProblemById(args[0], args[1]);
            default -> throw new AOCException("Invalid arguments. Either no argument or 2 arguments (day & part) must be provided");
        }
    }

    public Problem(@NonNull Day day, @NonNull Part part) {
        found = ProblemService.getProblemById(day, part);
    }

    @Override
    public @NonNull AOCProblemId id() {
        return found.id();
    }

    @Override
    public @NonNull Object solve() {
        return found.solve();
    }


}
