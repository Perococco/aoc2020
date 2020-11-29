package perococco.aoc.launcher;

import lombok.RequiredArgsConstructor;
import perococco.aoc.launcher._private.Launcher;
import perococco.aoc.launcher._private.ProblemService;
import perococco.aoc.api.AOCProblem;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class LaunchAll {

    public static void main(String[] args) {
        final List<AOCProblem<?>> problems = ProblemService.loadProblems()
                                                           .sorted(AOCProblem::compareTo)
                                                           .collect(Collectors.toList());


        problems.forEach(p -> new Launcher(p).launch());
    }

}

