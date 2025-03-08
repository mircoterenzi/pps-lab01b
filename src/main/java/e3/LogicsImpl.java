package e3;

import java.util.*;

import static java.lang.Math.abs;

public class LogicsImpl implements Logics {

    private final Random random = new Random();
    private final List<Pair<Integer, Integer>> cells = new ArrayList<>();
    private final List<Pair<Integer, Integer>> mines = new ArrayList<>();
    private final List<Pair<Integer, Integer>> flagged = new ArrayList<>();
    private final HashMap<Pair<Integer, Integer>, Integer> counters = new HashMap<>();
    private final int size;

    private void generateMines(int amount) {
        if (amount != 0) {
            Pair<Integer, Integer> pos = new Pair<>(this.random.nextInt(this.size), this.random.nextInt(this.size));
            if (!this.mines.contains(pos)) {
                this.mines.add(pos);
                amount--;
            }
            generateMines(amount);
        }
    }

    public LogicsImpl(int size, int mines) {
        this.size = size;
        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                this.cells.add(new Pair<>(x, y));
            }
        }
        generateMines(mines);
    }

    private boolean areAdjacent(Pair<Integer, Integer> first, Pair<Integer, Integer> second) {
        return abs(first.getX() - second.getX()) == 1 || abs(first.getY() - second.getY()) == 1;
    }

    @Override
    public boolean openCell(Pair<Integer, Integer> pos) {
        int adjacentMines = 0;
        for (Pair<Integer, Integer> cell : cells) {
            if (areAdjacent(pos, cell) && this.isMine(cell)) {
                adjacentMines++;
            }
        }
        counters.put(pos, adjacentMines);
        return isMine(pos);
    }

    @Override
    public boolean isGameCompleted() {
        return false;
    }

    @Override
    public void setFlag(Pair<Integer, Integer> pos, boolean value) {
        if (value) {
            this.flagged.add(pos);
        } else {
            this.flagged.remove(pos);
        }
    }

    @Override
    public boolean isFlagged(Pair<Integer, Integer> pos) {
        return flagged.contains(pos);
    }

    @Override
    public boolean isMine(Pair<Integer, Integer> pos) {
        return this.mines.contains(pos);
    }

    @Override
    public Optional<Integer> getCounter(Pair<Integer, Integer> pos) {
        return counters.containsKey(pos) ? Optional.of(counters.get(pos)) : Optional.empty();
    }
}
