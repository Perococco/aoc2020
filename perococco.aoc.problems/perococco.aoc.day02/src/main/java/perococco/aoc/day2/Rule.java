package perococco.aoc.day2;

import lombok.NonNull;

public interface Rule {

    boolean isPasswordValid(@NonNull Password password);
}
