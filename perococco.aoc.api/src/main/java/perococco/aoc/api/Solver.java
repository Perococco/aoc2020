package perococco.aoc.api;

import lombok.NonNull;

public interface Solver<I,S> {

    @NonNull S solve(@NonNull I input);
    @NonNull Day day();
    @NonNull Part part();
}
