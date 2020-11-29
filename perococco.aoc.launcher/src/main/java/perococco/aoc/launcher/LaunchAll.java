package perococco.aoc.launcher;

import lombok.RequiredArgsConstructor;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.launcher._private.Launcher;
import perococco.aoc.launcher._private.ProblemService;

@RequiredArgsConstructor
public class LaunchAll {

    public static void main(String[] args) {
        ProblemService.loadProblems()
                      .sorted(AOCProblem::compareTo)
                      .forEach(Launcher::launch);
    }

}

