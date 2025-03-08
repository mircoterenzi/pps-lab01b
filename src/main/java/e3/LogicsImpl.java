package e3;

import java.util.Optional;

public class LogicsImpl implements Logics {

    public LogicsImpl(int size) {
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

    }

    @Override
    public boolean isFlagged(Pair<Integer, Integer> pos) {
        return false;
    }

    @Override
    public boolean isMine(Pair<Integer, Integer> pos) {
        return false;
    }

    @Override
    public Optional<Integer> getCounter(Pair<Integer, Integer> pos) {
        return Optional.empty();
    }
}
