package e2;

public class LogicsImpl implements Logics {

    private final Pair<Integer,Integer> pawn;
    private Pair<Integer,Integer> knight;
    private final MoveValidator validator = new KnightMoveValidator();

    public LogicsImpl(int pawnRow, int pawnCol, int knightRow, int knightCol) {
        this.pawn = new Pair<>(pawnRow, pawnCol);
        this.knight = new Pair<>(knightRow, knightCol);
    }

    @Override
    public boolean hit(int row, int col) {
        Pair<Integer, Integer> newPosition = new Pair<>(row, col);
        if (validator.test(knight, newPosition)) {
            this.knight = newPosition;
            return this.pawn.equals(this.knight);
        }
        return false;
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.knight.equals(new Pair<>(row,col));
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.pawn.equals(new Pair<>(row,col));
    }
}
