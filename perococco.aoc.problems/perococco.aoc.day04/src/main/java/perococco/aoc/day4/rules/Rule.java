package perococco.aoc.day4.rules;

import lombok.NonNull;

public interface Rule<I, O> {

    @NonNull Validation<O> validate(@NonNull I input);

    default <P> @NonNull Rule<I, P> and(@NonNull Rule<? super O, P> after) {
        return i -> this.validate(i).apply(after);
    }

    static @NonNull Rule<String, Integer> fourDigitsBetween(int limitInf, int limitSup) {
        return HasSize.of(4).and(isIntegerBetween(limitInf,limitSup));
    }

    static Rule<String, Integer> isIntegerBetween(int limitInf, int limitSup) {
        return IsInteger.create()
                        .and(new IsAtLeast(limitInf))
                        .and(new IsAtMost(limitSup));
    }
    static <I> Rule<I,I> alwayValid() {
        return Validation::valid;
    }



}
