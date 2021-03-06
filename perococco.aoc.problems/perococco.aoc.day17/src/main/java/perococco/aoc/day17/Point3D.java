package perococco.aoc.day17;

import lombok.NonNull;
import lombok.Value;
import perococco.aoc.common.NeighbourProvider;

import java.util.stream.Stream;

@Value
public class Point3D implements NeighbourProvider<Point3D> {
    int x;
    int y;
    int z;


    public @NonNull Stream<Point3D> neighbours() {
        final int zp1 = z + 1;
        final int zm1 = z - 1;
        final int yp1 = y + 1;
        final int ym1 = y - 1;
        final int xp1 = x + 1;
        final int xm1 = x - 1;
        return Stream.of(
                Point3D.of(xp1, yp1, zp1), Point3D.of(xp1, y, zp1), Point3D.of(xp1, ym1, zp1),
                Point3D.of(x, yp1, zp1), Point3D.of(x, y, zp1), Point3D.of(x, ym1, zp1),
                Point3D.of(xm1, yp1, zp1), Point3D.of(xm1, y, zp1), Point3D.of(xm1, ym1, zp1),

                Point3D.of(xp1, yp1, z), Point3D.of(xp1, y, z), Point3D.of(xp1, ym1, z),
                Point3D.of(x, yp1, z), /*Point3D.of(x, y, z),*/ Point3D.of(x, ym1, z),
                Point3D.of(xm1, yp1, z), Point3D.of(xm1, y, z), Point3D.of(xm1, ym1, z),

                Point3D.of(xp1, yp1, zm1), Point3D.of(xp1, y, zm1), Point3D.of(xp1, ym1, zm1),
                Point3D.of(x, yp1, zm1), Point3D.of(x, y, zm1), Point3D.of(x, ym1, zm1),
                Point3D.of(xm1, yp1, zm1), Point3D.of(xm1, y, zm1), Point3D.of(xm1, ym1, zm1)
        );
    }


    public static @NonNull Point3D of(int x, int y, int z) {
        return new Point3D(x, y, z);
    }
}
