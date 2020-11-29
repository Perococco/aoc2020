package perococco.aoc.launcher;

import lombok.NonNull;
import perococco.aoc.launcher._private.ProblemService;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.api.AOCProblemId;
import perococco.aoc.api.Day;
import perococco.aoc.api.Part;
import perococco.aoc.common.AOCException;

import static perococco.aoc.launcher._private.ProblemService.findLastDefinedProblem;
import static perococco.aoc.launcher._private.ProblemService.getProgramById;

public class Problem implements AOCProblem<Object> {

    private final AOCProblem<?> found;

    public Problem(@NonNull String[] args) {
        switch (args.length) {
            case 0 : found = findLastDefinedProblem(); break;
            case 2 : found = getProgramById(args[0], args[1]); break;
            default:
                throw new AOCException("Invalid arguments. Either no argument or 2 arguments (day & part) must be provided");
        }
    }

    public Problem(@NonNull Day day, @NonNull Part part) {
        found = ProblemService.getProgramById(day, part);
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
