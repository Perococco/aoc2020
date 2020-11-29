package perococco.aoc.launcher._private;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.api.AOCProblem;

import java.io.PrintStream;

@RequiredArgsConstructor
public class Launcher {

    @NonNull
    @Getter
    private final AOCProblem<?> problem;

    public void launch() {
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

