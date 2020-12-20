package perococco.aoc.day19.structures;

import lombok.NonNull;

public interface Rule {

     <I,O> @NonNull O accept(@NonNull RuleVisitor<I,O> visitor, @NonNull I parameter);

    static @NonNull Rule parse(@NonNull String line) {
        final int indexOfPipe = line.indexOf('|');
        final int indexOfQuote = line.indexOf('"');
        if (indexOfPipe>=0) {
            return Or.parse(line);
        }
        if (indexOfQuote>=0) {
            return Literal.parse(line);
        }
        return Concatenation.parse(line);
    }

}
