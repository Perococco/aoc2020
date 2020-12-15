package perococco.aoc.day15;

public class NumberHistory {

    private final long number;

    private int lastTurn;

    private int oneBeforeLastTurn;

    public NumberHistory(long number, int turn) {
        this.number = number;
        this.lastTurn = turn;
        this.oneBeforeLastTurn = turn;
    }

    public long getNextToSay() {
        return lastTurn - oneBeforeLastTurn;
    }

    public void setLastSpokenTurn(int turn) {
        this.oneBeforeLastTurn = this.lastTurn;
        this.lastTurn = turn;
    }

    @Override
    public String toString() {
        return "NumberHistory{" + number + " | " + lastTurn + " - " + oneBeforeLastTurn + '}';
    }
}
