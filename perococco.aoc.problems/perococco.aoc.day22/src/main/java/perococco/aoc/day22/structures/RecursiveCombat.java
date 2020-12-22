package perococco.aoc.day22.structures;

import lombok.NonNull;
import lombok.Value;
import perococco.aoc.common.AOCException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Value
public class RecursiveCombat {

    public static @NonNull RecursiveCombat create(@NonNull GameSetup gameSetup) {
        return new RecursiveCombat(new RecursiveDeck(gameSetup.player1()), new RecursiveDeck(gameSetup.player2()));
    }

    RecursiveDeck player1;
    RecursiveDeck player2;

    public RecursiveDeck getDeckOf(@NonNull Player player) {
        return switch (player) {
            case PLAYER_ONE -> player1;
            case PLAYER_TWO -> player2;
        };
    }

    public @NonNull RecursiveCombat nextIfWinnerIs(@NonNull Player player) {
        return switch (player) {
            case PLAYER_ONE -> ifPlayer1Win();
            case PLAYER_TWO -> ifPlayer2Win();
        };
    }

    public @NonNull RecursiveCombatOutCome playGame() {
        final Set<RecursiveCombat> seenCombat = new HashSet<>();
        RecursiveCombat current = this;
        while (!current.isDone()) {
            if (seenCombat.contains(current)) {
                return new RecursiveCombatOutCome(Player.PLAYER_ONE, current);
            }
            seenCombat.add(current);
            final Player winner = current.getWinnerOfRound();
            current = current.nextIfWinnerIs(winner);
        }
        return current.createOutCome();
    }

    private @NonNull Player getWinnerOfRound() {
        return this.createSubGame()
                     .map(r -> r.playGame().winner())
                     .orElseGet(this::winnerFromStandardRound);
    }



    public boolean isDone() {
        return player1.hasNoCard() || player2.hasNoCard();
    }

    private @NonNull RecursiveCombat ifPlayer1Win() {
        final var newPlayer1 = player1.removeFirstAndAdd(player1.firstCard(),player2.firstCard());
        final var newPlayer2 = player2.removeFirst();
        return new RecursiveCombat(newPlayer1, newPlayer2);
    }

    private @NonNull RecursiveCombat ifPlayer2Win() {
        final var newPlayer1 = player1.removeFirst();
        final var newPlayer2 = player2.removeFirstAndAdd(player2.firstCard(),player1.firstCard());
        return new RecursiveCombat(newPlayer1, newPlayer2);
    }

    public @NonNull Player winnerFromStandardRound() {
        return (player1.firstCard() > player2.firstCard()) ? Player.PLAYER_ONE : Player.PLAYER_TWO;
    }

    public @NonNull Optional<RecursiveCombat> createSubGame() {
        if (player1.canRecurse() && player2.canRecurse()) {
            return Optional.of(new RecursiveCombat(player1.createSubDeck(), player2.createSubDeck()));
        }
        return Optional.empty();
    }


    public @NonNull RecursiveCombatOutCome createOutCome() {
        if (!isDone()) {
            throw new AOCException("Game not done");
        }
        final Player winner = player1.hasNoCard()?Player.PLAYER_TWO:Player.PLAYER_ONE;
        return new RecursiveCombatOutCome(winner,this);
     }

    @Override
    public String toString() {
        return "{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                '}';
    }
}
