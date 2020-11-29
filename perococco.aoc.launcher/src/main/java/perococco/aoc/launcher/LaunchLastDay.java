package perococco.aoc.launcher;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.launcher._private.Launcher;
import perococco.aoc.launcher._private.ProblemService;
import perococco.aoc.api.Day;
import perococco.aoc.api.Part;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class LaunchLastDay {

    public static void main(String[] args) {
        ProblemService.findLastDay()
                      .map(LaunchLastDay::new)
                      .ifPresentOrElse(d -> d.launch(), () -> System.err.println("No problem found"));

    }

    private final @NonNull Day day;

    public void launch() {
        ProblemService.listProgramsOfADay(day)
                      .forEach(Launcher::launch);
    }

}

