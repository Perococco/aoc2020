package perococco.aoc.day6.structures;

import lombok.NonNull;

import java.util.Arrays;

public enum Question {
    A,
    B,
    C,
    D,
    E,
    F,
    G,
    H,
    I,
    J,
    K,
    L,
    M,
    N,
    O,
    P,
    Q,
    R,
    S,
    T,
    U,
    V,
    W,
    X,
    Y,
    Z;

    public static @NonNull Question parse(int character) {
        final int idx = character - 'a';
        return Holder.VALUES[idx];
    }

    private static class Holder {
        private static final Question[] VALUES = Question.values();
    }
}
