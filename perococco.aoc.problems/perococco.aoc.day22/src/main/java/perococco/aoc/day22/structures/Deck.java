package perococco.aoc.day22.structures;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.Value;

@Value
public class Deck {

    ImmutableList<Integer> cards;

    public int firstCard() {
        return cards.get(0);
    }

    public @NonNull Deck newDeckIfLostRound() {
        return new Deck(cards.subList(1, cards.size()));
    }

    public @NonNull Deck newDeckIfWonRound(int cardOfLooser) {
        final ImmutableList.Builder<Integer> builder = ImmutableList.builder();
        builder.addAll(cards.subList(1,cards.size()));
        builder.add(firstCard());
        builder.add(cardOfLooser);
        return new Deck(builder.build());
    }

    public boolean canRecurse() {
        return firstCard()<=(cards.size()-1);
    }

    public @NonNull Deck createSubDeck() {
        assert canRecurse();
        return new Deck(cards.subList(1, 1+firstCard()));
    }


    public boolean hasNoCard() {
        return cards.isEmpty();
    }

    public @NonNull Score score() {
        return new Score(cards);
    }

    @Override
    public String toString() {
        return  cards.toString() ;
    }
}
