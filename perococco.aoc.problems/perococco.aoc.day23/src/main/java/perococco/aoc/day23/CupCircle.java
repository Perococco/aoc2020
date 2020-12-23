package perococco.aoc.day23;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class CupCircle {

    private final Node[] nodeByLabels;

    private Node current;

    private final int size;

    public CupCircle(String initialValues) {
        this(initialValues,initialValues.length());
    }

    public CupCircle(String initialValues, int size) {
        this(initialValues.chars().map(i -> i-'1').toArray(),size);
    }

    public CupCircle(int[] initialValues, int size) {
        this.size = size;
        this.nodeByLabels = new Node[size];
        final IntFunction<Node> createNode = i -> {Node n = new Node(i);nodeByLabels[i]=n;return n;};

        this.current = createNode.apply(initialValues[0]);

        Node previous = current;
        for (int i = 1; i < size; i++) {
            final int val = i < initialValues.length ? initialValues[i] : i;
            Node node = createNode.apply(val);
            previous.setNext(node);
            previous = node;
        }
        previous.setNext(current);
    }

    public @NonNull String part1Result() {
        final Node n1 = nodeByLabels[0];
        final StringBuilder sb = new StringBuilder();
        Node n = n1;
        do {
            n = n.next;
            if (n == n1) {
                return sb.toString();
            }
            sb.append(n.value+1);
        } while (true);
    }

    public @NonNull String part2Result() {
        final Node n1 = nodeByLabels[0];
        final var b1 = new BigDecimal(n1.next.value+1);
        final var b2 = new BigDecimal(n1.next.next.value+1);
        return b1.multiply(b2).toString();
    }

    public void performMoves(int nbMoves) {
        for (int i = 0; i < nbMoves; i++) {
            performOneMove();
        }
    }

    public void performOneMove() {
        int val = current.value;
        final var n1 = current.next;
        final var n2 = n1.next;
        final var n3 = n2.next;
        current.setNext(n3.next);

        int insertLabel = IntStream.of(-1, -2, -3, -4)
                               .map(o -> ((o + val + size) % size))
                               .filter(i -> n1.value != i && n2.value != i && n3.value != i)
                               .findFirst()
                               .getAsInt();

        @NonNull Node insert = nodeByLabels[insertLabel];

        Node insertNext = insert.next;
        insert.setNext(n1);
        n3.setNext(insertNext);

        current = current.next;
    }


    @EqualsAndHashCode(of = "value")
    @RequiredArgsConstructor
    private static class Node {

        private final int value;
        private Node next;

        public void setNext(Node node) {
            next = node;
        }

    }
}
