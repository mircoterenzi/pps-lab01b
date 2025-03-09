package e3;

import static java.lang.Math.abs;

public class CellImpl implements Cell {

    private final Pair<Integer, Integer> position;
    private boolean mine;

    public CellImpl(Pair<Integer, Integer> pos) {
        this.position = pos;
    }

    @Override
    public boolean isMine() {
        return this.mine;
    }

    @Override
    public void setMine(boolean value) {
        this.mine = value;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public boolean isAdjacentTo(Cell cell) {
        Pair<Integer, Integer> other = cell.getPosition();
        return abs(this.position.getX() - other.getX()) <= 1
                && abs(this.position.getY() - other.getY()) <= 1
                && !this.equals(cell);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Cell && this.position.equals(((Cell) object).getPosition());
    }
}

