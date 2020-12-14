package perococco.aoc.day14.structures;

import lombok.NonNull;
import perococco.aoc.common.AOCException;

public interface Instruction {

    static @NonNull Instruction parse(@NonNull String line) {
        if (line.startsWith("mask")) {
            return Mask.parse(line);
        } else if (line.startsWith("mem")) {
            return Setter.parse(line);
        }
        throw new AOCException("Could not parse line '"+line+"'");
    }

    void applyToMemory(@NonNull Memory memory);
}
