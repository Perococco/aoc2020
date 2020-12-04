package perococco.aoc.day4.structures;

import lombok.NonNull;

public interface ValidityRule {

    boolean isValid(@NonNull Passport passport);
}
