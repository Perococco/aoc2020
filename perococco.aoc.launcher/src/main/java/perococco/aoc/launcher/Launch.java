package perococco.aoc.launcher;

import lombok.RequiredArgsConstructor;
import perococco.aoc.launcher._private.Launcher;

@RequiredArgsConstructor
public class Launch {

    public static void main(String[] args) {
        new Launcher(new Problem(args)).launch();
    }

}

