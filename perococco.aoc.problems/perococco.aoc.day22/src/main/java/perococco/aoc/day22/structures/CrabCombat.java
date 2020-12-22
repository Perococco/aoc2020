package perococco.aoc.day22.structures;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CrabCombat {

    public static @NonNull CrabCombat from(@NonNull GameSetup setup) {
        return new CrabCombat(Deck.with(setup.player1()), Deck.with(setup.player2()));
    }

    private final @NonNull Deck player1;
    private final @NonNull Deck player2;

    public void playOneRound() {
        final int card1 = player1.pickFirstCard();
        final int card2 = player2.pickFirstCard();
        if (card1<card2) {
            player2.pushCards(card2,card1);
        } else {
            player1.pushCards(card1,card2);
        }
    }

    public boolean isGameEnded() {
        return player1.hasNoCard() || player2.hasNoCard();
    }

    @Override
    public String toString() {
        return "Game{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                '}';
    }

    public @NonNull long score() {
        return Math.max(player1.score(), player2.score());
    }
}
