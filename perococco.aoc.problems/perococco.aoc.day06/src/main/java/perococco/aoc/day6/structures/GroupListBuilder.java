package perococco.aoc.day6.structures;

import com.google.common.collect.ImmutableList;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.AOCException;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class GroupListBuilder {

    public static @NonNull ImmutableList<Group> build(@NonNull ImmutableList<String> input) {
        return new GroupListBuilder(input).build();
    }

    private final @NonNull ImmutableList<String> input;

    private final @NonNull ImmutableList.Builder<Group> listBuilder = ImmutableList.builder();

    private GroupBuilder groupBuilder = null;

    public @NonNull ImmutableList<Group> build() {
        int i = 0;
        for (String line : input) {
            i++;
            try {
                if (line.isBlank()) {
                    this.handleBlankLine();
                } else {
                    this.handleNotBlankLine(line);
                }
            } catch (Exception e) {
                throw new AOCException("Could not parse line #"+i+" : '"+line+"'",e);
            }
        }
        this.appendBuilderInProgressToList();

        return listBuilder.build();
    }

    private void handleBlankLine() {
        this.appendBuilderInProgressToList();
    }

    private void handleNotBlankLine(@NonNull String line) {
        this.createGroupBuilderIfNecessary();
        this.groupBuilder.addLine(line);
    }

    private void createGroupBuilderIfNecessary() {
        if (groupBuilder == null) {
            groupBuilder = Group.builder();
        }
    }

    private void appendBuilderInProgressToList() {
        if (groupBuilder != null) {
            listBuilder.add(groupBuilder.build());
            groupBuilder = null;
        }
    }

}
