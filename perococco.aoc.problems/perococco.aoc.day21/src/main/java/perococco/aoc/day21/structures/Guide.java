package perococco.aoc.day21.structures;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableSet;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.Bag;

import java.util.stream.Collector;

@RequiredArgsConstructor
public class Guide {

    @Getter
    private final @NonNull ImmutableBiMap<Allergen,Ingredient> allergenIdentification;

    @Getter
    private final @NonNull ImmutableSet<Ingredient> safeIngredients;

    @Getter
    private final @NonNull Bag<Ingredient> bagOfIngredients;

    public static Collector<String,?,Guide> collector() {
        return Collector.of(
                GuideBuilder::new,
                (b,s) -> b.addFood(Food.parse(s)),
                (b1,b2) -> b1.combine(b2),
                GuideBuilder::buildGuide
        );


    }
}
