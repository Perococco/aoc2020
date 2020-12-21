package perococco.aoc.common;

import lombok.NonNull;

public interface Bag<T> {

    int quantity(@NonNull T element);

    void addOne(@NonNull T element);

    void removeOne(@NonNull T element);


}
