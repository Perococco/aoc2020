package perococco.aoc.day13;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;

import java.math.BigInteger;

public interface Part2Solver {

    @NonNull BigInteger solve(@NonNull ImmutableList<Bus> buses);
}
