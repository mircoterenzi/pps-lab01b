package e3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class LogicsImpl implements Logics {

    private final Random random = new Random();
    private final List<Pair<Integer, Integer>> mines = new ArrayList<>();
    private final List<Pair<Integer, Integer>> flagged = new ArrayList<>();
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
        generateMines(mines);
    }

    @Override
    public boolean openCell(Pair<Integer, Integer> pos) {
        return false;
    }

    @Override
    public boolean isGameCompleted() {
        return false;
    }

    @Override
    public void setFlag(Pair<Integer, Integer> pos, boolean value) {
        this.flagged.add(pos);
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
        return Optional.empty();
    }
}
