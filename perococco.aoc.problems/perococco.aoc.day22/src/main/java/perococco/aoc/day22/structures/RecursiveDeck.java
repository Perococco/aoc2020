package perococco.aoc.day22.structures;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.Value;

@Value
public class RecursiveDeck {

    ImmutableList<Integer> cards;

    public int firstCard() {
        return cards.get(0);
    }

    public boolean canRecurse() {
        return firstCard()<=(cards.size()-1);
    }

    public @NonNull RecursiveDeck createSubDeck() {
        assert canRecurse();
        return new RecursiveDeck(cards.subList(1,1+firstCard()));
    }

    public @NonNull RecursiveDeck removeFirst() {
        return new RecursiveDeck(cards.subList(1,cards.size()));
    }

    public @NonNull RecursiveDeck removeFirstAndAdd(int first, int second) {
        final ImmutableList.Builder<Integer> builder = ImmutableList.builder();
        builder.addAll(cards.subList(1,cards.size()));
        builder.add(first);
        builder.add(second);
        return new RecursiveDeck(builder.build());
    }

    public boolean hasSomeCards() {
        return !cards.isEmpty();
    }
    public boolean hasNoCard() {
        return cards.isEmpty();
    }

    public long score() {
        long value = 0;
        long factor = cards.size();
        for (int card : cards) {
            value += card*factor;
            factor--;
        }
        return value;
    }

    @Override
    public String toString() {
        return  cards.toString() ;
    }
}
