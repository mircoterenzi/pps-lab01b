package e3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    public static final int SIZE = 2;
    public static final int MINES = 1;

    private List<Pair<Integer, Integer>> getPositions() {
        List<Pair<Integer, Integer>> positions = new ArrayList<>();
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                positions.add(new Pair<>(x, y));
            }
        }
        return positions;
    }

    @Test
    public void testListAdjacentCells() {
        Board board = new BoardImpl(SIZE, MINES);
        List<Pair<Integer, Integer>> positionList = this.getPositions();
        List<Pair<Integer, Integer>> adjacentList = board.getCellsAdjacentTo(positionList.removeFirst());
        System.out.println(positionList);
        System.out.println(adjacentList);
        assertAll(
                () -> assertTrue(positionList.containsAll(adjacentList)),
                () -> assertTrue(adjacentList.containsAll(positionList))
        );
    }
}
