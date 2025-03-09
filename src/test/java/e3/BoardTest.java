package e3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    public static final int SIZE = 2;
    public static final int SINGLE_CELL_SIZE = 1;
    public static final int NO_MINES = 0;
    public static final int SINGLE_MINE = 1;

    private List<Pair<Integer, Integer>> getPositions() {
        List<Pair<Integer, Integer>> positions = new ArrayList<>();
        for (int x = NO_MINES; x < SIZE; x++) {
            for (int y = NO_MINES; y < SIZE; y++) {
                positions.add(new Pair<>(x, y));
            }
        }
        return positions;
    }

    @Test
    public void testInitiallyNoMines() {
        Board board = new BoardImpl(SINGLE_CELL_SIZE, NO_MINES);
        assertFalse(board.isMine(this.getPositions().getFirst()));
    }

    @Test
    public void testGetTrueIfCellIsMine() {
        Board board = new BoardImpl(SINGLE_CELL_SIZE, SINGLE_MINE);
        assertTrue(board.isMine(this.getPositions().getFirst()));
    }

    @Test
    public void testGetExceptionIfMoreMinesThanCells() {
        assertThrows(IllegalArgumentException.class, () -> {
            Board board = new BoardImpl(SINGLE_CELL_SIZE, SINGLE_MINE + 1);
        });
    }

    @Test
    public void testListAdjacentCells() {
        Board board = new BoardImpl(SIZE, SINGLE_MINE);
        List<Pair<Integer, Integer>> positionList = this.getPositions();
        List<Pair<Integer, Integer>> adjacentList = board.getCellsAdjacentTo(positionList.removeFirst());
        System.out.println(positionList);
        System.out.println(adjacentList);
        assertAll(
                () -> assertTrue(positionList.containsAll(adjacentList)),
                () -> assertTrue(adjacentList.containsAll(positionList))
        );
    }

    @Test
    public void testAmountZeroIfThereAreNoMines() {
        Board board = new BoardImpl(SIZE, NO_MINES);
        assertEquals(NO_MINES, board.getAmountMinesAdjacentTo(this.getPositions().getFirst()));
    }

    @Test
    public void testAmountIfMinesArePresent() {
        Board board = new BoardImpl(SIZE, SINGLE_MINE);
        Pair<Integer, Integer> position = this.getPositions().getFirst();
        int minesAdjacentToPosition = SINGLE_MINE;
        if (board.isMine(position)) {
            minesAdjacentToPosition--;
        }
        assertEquals(minesAdjacentToPosition, board.getAmountMinesAdjacentTo(position));
    }
}
