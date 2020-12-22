package perococco.aoc.day22;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day22.structures.GameSetup;
import perococco.aoc.day22.structures.RecursiveCombat;
import perococco.aoc.day22.structures.RecursiveCombatOutCome;

public class Day22Part2Solver extends Day22Solver<Long> {

    public static @NonNull AOCProblem<?> provider() {
        return new Day22Part2Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull GameSetup input) {

        final RecursiveCombat recursiveCombat = RecursiveCombat.create(input);
        final RecursiveCombatOutCome outCome = recursiveCombat.playGame();

        return outCome.getWinnerDeck().score();
    }

}
