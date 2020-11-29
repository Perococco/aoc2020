package perococco.aoc.input;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.api.AOCProblem;
import perococco.aoc.api.Day;
import perococco.aoc.api.Part;
import perococco.aoc.api.Solver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public abstract class SmartSolver<I,S> implements Solver<I,S> {

    private static final Pattern DAY_PART = Pattern.compile("Day([0-9]+)Part([12]).+");

    private final @NonNull Day day;
    private final @NonNull Part part;

    public SmartSolver() {
        final Matcher matcher = DAY_PART.matcher(this.getClass().getSimpleName());
        if (!matcher.matches()) {
            throw new RuntimeException("Solver must provide DAY and PART by parameter or by having its name of the form DayXXParY");
        }
        this.day = Day.parse(matcher.group(1));
        this.part = Part.parse(matcher.group(2));
    }

    protected abstract @NonNull Converter<I> getConverter();

    public @NonNull AOCProblem<S> createProblem() {
        return AOCProblemUsingSolver.create(day,part,this,this.getConverter());
    }

}
