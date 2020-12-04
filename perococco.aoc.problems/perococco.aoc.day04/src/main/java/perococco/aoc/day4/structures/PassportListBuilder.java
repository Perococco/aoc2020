package perococco.aoc.day4.structures;

import com.google.common.collect.ImmutableList;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PassportListBuilder {

    public static @NonNull ImmutableList<Passport> build(@NonNull ImmutableList<String> input) {
        return new PassportListBuilder(input).build();
    }

    private final @NonNull ImmutableList<String> input;

    private final @NonNull ImmutableList.Builder<Passport> listBuilder = ImmutableList.builder();

    private PassportBuilder passportBuilder = null;

    public @NonNull ImmutableList<Passport> build() {
        for (String line : input) {
            if (line.isBlank()) {
                this.handleBlankLine();
            } else {
                this.handleNotBlankLine(line);
            }
        }
        this.appendBuilderInProgressToList();

        return listBuilder.build();
    }

    private void handleBlankLine() {
        this.appendBuilderInProgressToList();
    }

    private void handleNotBlankLine(@NonNull String line) {
        this.createPassportBuilderIfNecessary();
        this.passportBuilder.addLine(line);
    }

    private void createPassportBuilderIfNecessary() {
        if (passportBuilder == null) {
            passportBuilder = Passport.builder();
        }
    }

    private void appendBuilderInProgressToList() {
        if (passportBuilder != null) {
            listBuilder.add(passportBuilder.build());
            passportBuilder = null;
        }
    }


}
