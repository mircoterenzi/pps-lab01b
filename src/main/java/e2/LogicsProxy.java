package e2;

public class LogicsProxy implements Logics {

	private Logics logics;

	public LogicsProxy(int size){
		this.logics = new LogicsImpl(size);
	}

	public LogicsProxy(int size, int pawnRow, int pawnCol, int knightRow, int knightCol) {
		this.logics = new LogicsImpl(size, pawnRow, pawnCol, knightRow, knightCol);
	}

	@Override
	public boolean hit(int row, int col) {
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
