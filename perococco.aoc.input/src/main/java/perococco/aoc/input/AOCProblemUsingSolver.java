package perococco.aoc.input;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.api.*;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @param <S> the type of the solution
 * @param <I> the type of the input
 */
@RequiredArgsConstructor
public class AOCProblemUsingSolver<I, S> implements AOCProblem<S> {


    public static <I, S> @NonNull AOCProblem<S> create(
            @NonNull Day day,
            @NonNull Part part,
            @NonNull Solver<I,S> solver,
            @NonNull Input<Stream<String>> input,
            @NonNull Converter<? extends I> converter
    ) {
        return new AOCProblemUsingSolver<>(
                day.createIdWith(part),
                input.map(converter),
                solver
        );
    }

    public static <I, S> @NonNull AOCProblem<S> create(
            @NonNull Day day,
            @NonNull Part part,
            @NonNull Solver<I,S> solver,
            @NonNull Converter<? extends I> converter
    ) {
        return create(day,part,solver,new ResourceFile(day),converter);
    }

    public static <S> @NonNull AOCProblem<S> lineByLine(
            @NonNull Day day,
            @NonNull Part part,
            @NonNull Solver<Stream<String>,S> solver
    ) {
        return create(day,part,solver,i -> i);
    }

    public static <I, S> @NonNull AOCProblem<S> lineByLine(
            @NonNull Day day,
            @NonNull Part part,
            @NonNull Solver<Stream<I>,S> solver,
            @NonNull Function<? super String, ? extends I> lineConverter
    ) {
        return create(day,part,solver,i -> i.map(lineConverter));
    }

    @NonNull
    @Getter
    private final AOCProblemId id;

    private final Input<I> input;

    private final Solver<I, S> solver;

    @NonNull
    public Part part() {
        return id.part();
    }

    @Override
    public @NonNull S solve() {
        final I input = this.input.readData();
        return solver.solve(input);
    }

    @Override
    public String toString() {
        return "AOCProblem{" +id.day()+" "+id.part()+"}";
    }
}
