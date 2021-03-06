package perococco.aoc.day11;

import lombok.NonNull;
import perococco.aoc.common.ArrayOfChar;
import perococco.aoc.common.GridHelper;
import perococco.aoc.common.SimpleGridHelper;
import perococco.aoc.day11.structures.AdjacentCounter;
import perococco.aoc.day11.structures.SeatLayoutLife;
import perococco.aoc.day11.structures.StateEvolutionRule;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

public abstract class Day11Solver extends SmartSolver<SeatLayoutLife,Long> {

    @Override
    protected @NonNull Converter<SeatLayoutLife> getConverter() {
        return Converter.TO_ARRAY_OF_CHAR.andThen(this::createSeatLayout);
    }

    private @NonNull SeatLayoutLife createSeatLayout(@NonNull ArrayOfChar chars) {
        final GridHelper gridHelper = new SimpleGridHelper(chars.width(),chars.height());
        return new SeatLayoutLife(gridHelper, createEvolutionRule(), createCounter(gridHelper), chars);
    }

    protected abstract @NonNull AdjacentCounter createCounter(@NonNull GridHelper gridHelper);

    protected abstract @NonNull StateEvolutionRule createEvolutionRule();

    @Override
    public @NonNull Long solve(@NonNull SeatLayoutLife seatLayoutLife) {
        while (seatLayoutLife.evolving());
        return seatLayoutLife.totalNumberOfOccupiedSeats();
    }

}
