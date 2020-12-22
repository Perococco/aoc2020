package perococco.aoc.day22.structures;

import lombok.NonNull;
import lombok.Value;

@Value
public class GameOutcome {

    @NonNull Player winner;
    @NonNull Score score;

}
