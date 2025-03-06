package e2;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;
	private final MoveValidator validator = new KnightMoveValidator();
	private final BoardImpl board;
	private final int size;
	 
    public LogicsImpl(int size){
		this.board = new BoardImpl(size);
    	this.size = size;
        this.pawn = this.board.randomPosition();
        do {
			this.knight = this.board.randomPosition();
		} while (this.knight != this.pawn);
    }

	public LogicsImpl(int size, int pawnRow, int pawnCol, int knightRow, int knightCol) {
		this.board = new BoardImpl(size);
		this.size = size;
		this.pawn = new Pair<>(pawnRow, pawnCol);
		this.knight = new Pair<>(knightRow, knightCol);
	}
    
	@Override
	public boolean hit(int row, int col) {
		Pair<Integer, Integer> newPosition = new Pair<>(row, col);
		this.board.checkBoundaries(newPosition);
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
