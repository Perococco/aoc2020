package perococco.aoc.day4;

import lombok.NonNull;

public interface ValidityRule {

    boolean isValid(@NonNull Passport passport);
}
