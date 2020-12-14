package perococco.aoc.day14.structures;

import lombok.NonNull;

public interface Memory {

    void setValue(int address, long value);

    void setActiveMask(@NonNull Mask mask);

    long sumOfAllValues();
}
