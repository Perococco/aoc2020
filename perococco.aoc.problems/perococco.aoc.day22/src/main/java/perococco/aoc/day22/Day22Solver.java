package perococco.aoc.day22;

import lombok.NonNull;
import perococco.aoc.day22.structures.GameExecutor;
import perococco.aoc.day22.structures.GameRules;
import perococco.aoc.day22.structures.GameState;
import perococco.aoc.day22.structures.Score;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

public abstract class Day22Solver extends SmartSolver<GameState, Score> {

    @Override
    protected @NonNull Converter<GameState> getConverter() {
        return Converter.ALL_LINES.andThen(GameState::parse);
    }

    protected abstract @NonNull GameRules getGameRules();

    @Override
    public final @NonNull Score solve(@NonNull GameState state) {
        final var rules = getGameRules();
        final var gameExecutor = new GameExecutor(rules);

        final var outcome = gameExecutor.play(state);

        return outcome.score();

    }
}
