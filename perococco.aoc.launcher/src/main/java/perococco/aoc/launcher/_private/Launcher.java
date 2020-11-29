package perococco.aoc.launcher._private;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.launcher.Launch;

import java.io.PrintStream;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Launcher {

    public static void launch(@NonNull AOCProblem<?> problem) {
        new Launcher(problem).launch();
    }

    @NonNull
    @Getter
    private final AOCProblem<?> problem;

    private void launch() {
        try {
            final Object solution = problem.solve();
            displayMessage(String.valueOf(solution));
        } catch (Throwable t) {
            displayError(t);
        }
    }

    private void displayMessage(@NonNull String message) {
        displayMessage(System.out,message);
    }

    private void displayError(@NonNull Throwable throwable) {
        displayMessage(System.err,"An error occurred : "+throwable.getMessage());
        throwable.printStackTrace();
    }

    private void displayMessage(@NonNull PrintStream ps, @NonNull String message) {
        ps.format("%s %s : %s%n", problem.id().day(), problem.id().part(), message);
    }

}

