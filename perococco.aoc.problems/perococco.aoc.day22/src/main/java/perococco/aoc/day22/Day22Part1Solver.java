package perococco.aoc.day22;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day22.structures.CrabCombat;
import perococco.aoc.day22.structures.GameSetup;

public class Day22Part1Solver extends Day22Solver<Long> {

    public static @NonNull AOCProblem<?> provider() {
        return new Day22Part1Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull GameSetup input) {
        final var game = CrabCombat.from(input);
        while (!game.isGameEnded()) {
            game.playOneRound();
        }
        return game.score();
    }
}
