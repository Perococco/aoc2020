package perococco.aoc.day12;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.common.Orientation;
import perococco.aoc.day12.structures.Executor;
import perococco.aoc.day12.structures.Ferry;
import perococco.aoc.day12.structures.Movement;
import perococco.aoc.day12.structures.Part1Executor;

public class Day12Part1Solver extends Day12Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day12Part1Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull ImmutableList<Movement> movements) {
        final Ferry ferry = new Ferry(Orientation.E, 0, 0);
        final Executor ex = new Part1Executor(ferry);

        movements.forEach(ex::execute);


        return ferry.manhattanDistance();
    }

}
