package perococco.aoc.day22.structures;

import lombok.NonNull;
import lombok.Value;

@Value
public class RecursiveCombatOutCome {

    @NonNull Player winner;
    @NonNull RecursiveCombat recursiveCombat;

    public @NonNull RecursiveDeck getWinnerDeck() {
        return recursiveCombat.getDeckOf(winner);
    }
}
