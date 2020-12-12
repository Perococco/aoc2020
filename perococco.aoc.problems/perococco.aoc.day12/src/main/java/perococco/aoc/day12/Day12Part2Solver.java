package perococco.aoc.day12;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.Orientation;
import perococco.aoc.day12.structures.*;

public class Day12Part2Solver extends Day12Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day12Part2Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull ImmutableList<Movement> movements) {
        final Ferry ferry = new Ferry(Orientation.E, 0, 0);
        final Waypoint waypoint = new Waypoint(10, 1);

        final Executor executor = new Part2Executor(ferry, waypoint);
        movements.forEach(executor::execute);

        return ferry.manhattanDistance();
    }
}
