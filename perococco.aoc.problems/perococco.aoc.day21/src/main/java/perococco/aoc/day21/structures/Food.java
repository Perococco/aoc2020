package perococco.aoc.day21.structures;

import com.google.common.collect.ImmutableSet;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class Food {

    public static @NonNull Food parse(@NonNull String line) {
        final int idxOfAllergens = line.indexOf("(contains ");
        final String ingredientsPart;
        final String allergensPart;
        if (idxOfAllergens<0) {
            ingredientsPart = line.trim();
            allergensPart = "";
        }  else {
            ingredientsPart = line.substring(0,idxOfAllergens);
            allergensPart = line.trim().substring(idxOfAllergens+"(contains ".length(),line.length()-1);
        }

        return new Food(
                Arrays.stream(ingredientsPart.split(" ")).map(Ingredient::new).collect(ImmutableSet.toImmutableSet()),
                allergensPart.isEmpty()?ImmutableSet.of():Arrays.stream(allergensPart.split(","))
                                                                .map(String::trim)
                                                                .map(Allergen::new)
                                                                .collect(ImmutableSet.toImmutableSet())
        );
    }

    @Getter
    private final @NonNull ImmutableSet<Ingredient> ingredients;
    @Getter
    private final @NonNull ImmutableSet<Allergen> allergens;

    @Override
    public String toString() {
        return ingredients.stream().map(Ingredient::name).collect(Collectors.joining(" "))
                +allergens.stream().map(Allergen::name).collect(Collectors.joining(", ", " (contains ", ")"));
    }

}
