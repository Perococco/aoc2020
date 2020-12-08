package perococco.aoc.day8.structures;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Program {

    @Getter
    private final @NonNull ImmutableList<Instruction> code;

    public @NonNull Instruction getInstructionAt(int pointer) {
        return code.get(pointer);
    }

    public int codeSize() {
        return code.size();
    }
}
