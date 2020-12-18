package perococco.aoc.day17;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.ArrayOfChar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class GameOfLife<T extends NeighbourProvider<T>> {

    public static @NonNull GameOfLife<Point3D> initializeIn3D(@NonNull ArrayOfChar arrayOfChar) {
        return initialize(arrayOfChar,(x,y) -> Point3D.of(x,y,0));
    }

    public static @NonNull GameOfLife<Point4D> initializeIn4D(@NonNull ArrayOfChar arrayOfChar) {
        return initialize(arrayOfChar,(x,y) -> Point4D.of(x,y,0,0));

    }
    public static <T extends NeighbourProvider<T>> @NonNull GameOfLife<T> initialize(@NonNull ArrayOfChar arrayOfChar, @NonNull BiFunction<Integer,Integer,? extends T> pointFactory) {
        final Set<T> listOfPoints = new HashSet<>();
        for (int y = 0; y < arrayOfChar.height(); y++) {
            for (int x = 0; x < arrayOfChar.width(); x++) {
                if (arrayOfChar.get(x,y) == '#') {
                    listOfPoints.add(pointFactory.apply(x,y));
                }
            }
        }
        return new GameOfLife<T>(listOfPoints);
    }

    private @NonNull Set<T> activeCubes;
    private final @NonNull Map<T,Integer> neighbourCount = new HashMap<>();

    public void performCycles(int numberOfCycles) {
        for (int i = 0; i < numberOfCycles; i++) {
            performOneCycle();
        }
    }

    private void performOneCycle() {
        this.clearNeighbourCount();
        activeCubes.forEach(cube -> increaseNeighbourCount(cube));
        this.updateActiveCubes();
    }

    private void clearNeighbourCount() {
        this.neighbourCount.clear();
    }

    private void increaseNeighbourCount(@NonNull T cube) {
        cube.neighbours().forEach(this::increaseNeighbourCountAt);
    }

    private void increaseNeighbourCountAt(T position) {
        neighbourCount.merge(position, 1, Integer::sum);
    }

    private void updateActiveCubes() {
        final Set<T> newActiveCubes = new HashSet<>();
        neighbourCount.forEach((p,n) -> {
            switch (n) {
                case 3 -> newActiveCubes.add(p);
                case 2 -> {
                    if (activeCubes.contains(p)) {
                        newActiveCubes.add(p);
                    }
                }
                default -> {}
            }
        });
        activeCubes.clear();
        activeCubes = newActiveCubes;
    }

    // nb-voisin    0 1 2 3 4 5 6 ---
    // active       0
    // active-next     1/0  1

    public long numberOfActiveCubes() {
        return activeCubes.size();
    }

}
