package perococco.aoc.day22.structures;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Deque;
import java.util.LinkedList;

@RequiredArgsConstructor
public class Deck {

    public static Deck with(@NonNull ImmutableList<Integer> cards) {
        return new Deck(new LinkedList<>(cards));
    }

    private final Deque<Integer> cards;

    public int pickFirstCard() {
        return cards.removeFirst();
    }

    public void pushCards(int first, int second) {
        cards.addLast(first);
        cards.addLast(second);
    }

    @Override
    public String toString() {
        return "{" + cards + '}';
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
}
