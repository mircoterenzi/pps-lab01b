package e3;

import java.util.*;

public class LogicsImpl implements Logics {

    private final List<Pair<Integer, Integer>> flagged = new ArrayList<>();
    private final List<Pair<Integer, Integer>> visited = new ArrayList<>();
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
        if (!this.visited.contains(pos)) {
            this.visited.add(pos);
            if (this.board.getAmountMinesAdjacentTo(pos) == 0) {
                this.board.getCellsAdjacentTo(pos).forEach(this::visit);
            }
        }
        return false;
    }

    @Override
    public boolean isGameCompleted() {
        return this.visited.size() == this.size * this.size - this.mines;
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
        return this.flagged.contains(pos);
    }

    @Override
    public Optional<Integer> getCounter(Pair<Integer, Integer> pos) {
        return this.visited.contains(pos) ? Optional.of(this.board.getAmountMinesAdjacentTo(pos)) : Optional.empty();
    }
}

