package e3;

import java.util.*;

public class LogicsImpl implements Logics {

    private final Tracker visited = new VisitTracker();
    private final Manager flagManager = new FlagManager();
    private final Board board;
    private final int size, mines;

    public LogicsImpl(int size, int mines) {
        this.size = size;
        this.mines = mines;
        this.board = new BoardImpl(size, mines);
    }

    @Override
    public boolean isMine(Pair<Integer, Integer> pos) {
        return this.board.isMine(pos);
    }

    @Override
    public boolean visit(Pair<Integer, Integer> pos) {
        if (this.isMine(pos)) {
            return true;
        }
        if (!this.visited.isTracked(pos)) {
            this.visited.track(pos);
            if (this.board.getAmountMinesAdjacentTo(pos) == 0) {
                this.board.getCellsAdjacentTo(pos).forEach(this::visit);
            }
        }
        return false;
    }

    @Override
    public boolean isGameCompleted() {
        return this.visited.getCount() == this.size * this.size - this.mines;
    }

    @Override
    public void setFlag(Pair<Integer, Integer> pos, boolean value) {
        this.flagManager.set(pos, value);
    }

    @Override
    public boolean isFlagged(Pair<Integer, Integer> pos) {
        return this.flagManager.getValue(pos);
    }

    @Override
    public Optional<Integer> getCounter(Pair<Integer, Integer> pos) {
        return this.visited.isTracked(pos) ? Optional.of(this.board.getAmountMinesAdjacentTo(pos)) : Optional.empty();
    }
}

