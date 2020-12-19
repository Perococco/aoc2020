package perococco.aoc.day19;

import lombok.NonNull;
import perococco.aoc.day19.structures.BasicMatcher;
import perococco.aoc.day19.structures.Day19Input;
import perococco.aoc.input.Converter;
import perococco.aoc.input.SmartSolver;

public abstract class Day19Solver extends SmartSolver<Day19Input,Long> {

    @Override
    protected @NonNull Converter<Day19Input> getConverter() {
        return Converter.ALL_LINES.andThen(Day19Input::parse);
    }

    protected abstract @NonNull Day19Input modifyInput(@NonNull Day19Input input);

    @Override
    public final @NonNull Long solve(@NonNull Day19Input input) {
        final var modifiedInput = modifyInput(input);
        final var tester = new BasicMatcher(modifiedInput.rules());

        return modifiedInput.messages().stream().filter(tester).count();
    }
}
