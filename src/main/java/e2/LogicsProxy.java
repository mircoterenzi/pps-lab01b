package e2;

public class LogicsProxy implements Logics {

	private final BoardImpl board;
	private final Logics logics;

	public LogicsProxy(int size){
		this.board = new BoardImpl(size);
		Pair<Integer, Integer> pawn = this.board.randomPosition();
		Pair<Integer, Integer> knight;
		do {
			knight = this.board.randomPosition();
		} while (knight != pawn);
		this.logics = new LogicsImpl(pawn.getX(), pawn.getY(), knight.getX(), knight.getY());
	}

	public LogicsProxy(int size, int pawnRow, int pawnCol, int knightRow, int knightCol) {
		this.board = new BoardImpl(size);
		this.logics = new LogicsImpl(pawnRow, pawnCol, knightRow, knightCol);
	}

	@Override
	public boolean hit(int row, int col) {
		this.board.checkBoundaries(new Pair<>(row, col));
		return this.logics.hit(row, col);
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.logics.hasKnight(row, col);
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.logics.hasPawn(row, col);
	}
}
