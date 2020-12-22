package perococco.aoc.day22;

import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.day22.structures.GameRules;
import perococco.aoc.day22.structures.RecursiveCombatRules;

public class Day22Part2Solver extends Day22Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day22Part2Solver().createProblem();
    }

    @Override
    protected @NonNull GameRules getGameRules() {
        return new RecursiveCombatRules();
    }
}
