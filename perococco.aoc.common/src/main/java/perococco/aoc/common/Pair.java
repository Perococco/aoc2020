package perococco.aoc.common;

import lombok.*;

import java.util.Map;

@Value
public class Pair<A,B> {

    @NonNull A first;
    @NonNull B second;

    public static <A,B> @NonNull Pair<A,B> of(@NonNull A a, @NonNull B b) {
        return new Pair(a,b);
    }

    public @NonNull Pair<B,A> swap() {
        return of(second,first);
    }

    public void addToMap(@NonNull Map<? super A, ? super B> target) {
        target.put(first,second);
    }

}
