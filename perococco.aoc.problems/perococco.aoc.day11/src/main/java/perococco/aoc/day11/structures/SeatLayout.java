package perococco.aoc.day11.structures;

import lombok.Getter;
import lombok.NonNull;
import perococco.aoc.common.ArrayOfChar;
import perococco.aoc.common.GridHelper;
import perococco.aoc.common.Position;
import perococco.aoc.common.SimpleGridHelper;

import java.util.Arrays;

public class SeatLayout implements ReadOnlySeatLayout {

    private final @NonNull GridHelper gridHelper;
    private final @NonNull StateEvolutionRule stateEvolutionRule;
    private final @NonNull AdjacentCounter adjacentCounter;
    private final State[] layout;

    private final long[] nbOccupiedAround;

    @Getter
    private final int width;
    @Getter
    private final int height;


    public SeatLayout(@NonNull GridHelper gridHelper,
                      @NonNull StateEvolutionRule stateEvolutionRule,
                      @NonNull AdjacentCounter adjacentCounter,
                      @NonNull ArrayOfChar input) {
        this.gridHelper = gridHelper;
        this.stateEvolutionRule = stateEvolutionRule;
        this.adjacentCounter = adjacentCounter;
        assert gridHelper.width() == input.width();
        assert gridHelper.height() == input.height();
        this.width = input.width();
        this.height = input.height();

        layout = new State[width * height];
        nbOccupiedAround = new long[width * height];

        Arrays.fill(layout, State.FLOOR);
        gridHelper.allPositionOnGrid()
                  .filter(p -> input.get(p) == 'L')
                  .forEach(p -> layout[gridHelper.linearIndexFor(p)] = State.EMPTY_SEAT);
    }

    @Override
    public @NonNull boolean isFloorAt(@NonNull Position position) {
        return layout[position.linearIndex(width)] == State.FLOOR;
    }

    @Override
    public @NonNull boolean isEmptySeat(@NonNull Position position) {
        return layout[position.linearIndex(width)] == State.EMPTY_SEAT;
    }

    @Override
    public @NonNull boolean isOccupiedSeat(@NonNull Position position) {
        return layout[position.linearIndex(width)] == State.OCCUPIED_SEAT;
    }

    public @NonNull State stateAt(@NonNull Position position) {
        return layout[position.linearIndex(width)];
    }

    /**
     * @return true if any changed occurred
     */
    public boolean evolving() {
        Arrays.fill(nbOccupiedAround, 0);
        gridHelper.allPositionOnGrid()
                  .forEach(p -> nbOccupiedAround[p.linearIndex(width)] = numberOfOccupiedAdjacentSeats(p));

        boolean anyChange = false;
        for (int i = 0; i < nbOccupiedAround.length; i++) {
            final long nbOccupied = nbOccupiedAround[i];
            final State oldState = layout[i];
            layout[i] = stateEvolutionRule.evaluateNewSate(oldState, nbOccupied);
            if (oldState != layout[i]) {
                anyChange = true;
            }
        }

        return anyChange;
    }

    private long numberOfOccupiedAdjacentSeats(@NonNull Position position) {
        return adjacentCounter.countOccupied(this,position);
    }

    public long totalNumberOfOccupiedSeats() {
        return  gridHelper.allPositionOnGrid().filter(this::isSeatOccupied).count();
    }


    private @NonNull boolean isSeatOccupied(@NonNull Position position) {
        return layout[position.linearIndex(width)] == State.OCCUPIED_SEAT;
    }

}
