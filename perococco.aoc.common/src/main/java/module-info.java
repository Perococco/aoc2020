module perococco.aoc.common {
    requires static lombok;
    requires java.desktop;

    requires com.google.common;

    exports perococco.aoc.common;
    exports perococco.aoc.common.rules;
}