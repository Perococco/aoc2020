package perococco.aoc.day2.structures;

import lombok.NonNull;

public interface Rule {

    boolean isPasswordValid(@NonNull Password password);
}
