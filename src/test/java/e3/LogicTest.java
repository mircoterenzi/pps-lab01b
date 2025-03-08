package e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    public static final int SIZE = 5;
    public static final int MINES = 3;
    public static final Pair<Integer, Integer> CELL = new Pair<>(2,2);
    private Logics logics;

    @BeforeEach
    public void setUp() {
        this.logics = new LogicsImpl(SIZE, MINES);
    }

    private List<Pair<Integer, Integer>> getCellList() {
        List<Pair<Integer, Integer>> cells = new ArrayList<>();
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                cells.add(new Pair<>(x, y));
            }
        }
        return cells;
    }

    private <X> X checkOnEachCell(X initialValue, BiFunction<Pair<Integer, Integer>, X, X> updateFunction) {
        X value = initialValue;
        for (Pair<Integer, Integer> cell : getCellList()) {
            value = updateFunction.apply(cell, value);
        }
        return value;
    }

    @Test
    public void testInitiallyNotFlagged() {
        assertFalse(checkOnEachCell(
                false,
                (cell, isAtLeastOneFlagged) ->
                        isAtLeastOneFlagged || this.logics.isFlagged(cell)
        ));
    }

    @Test
    public void testInitiallyGameNotWon() {
        assertFalse(this.logics.isGameCompleted());
    }

    @Test
    public void testRightMinesAmountGeneration() {
        assertEquals(
                MINES,
                checkOnEachCell(0, (cell, mineCounter) ->
                        this.logics.isMine(cell) ? mineCounter + 1 : mineCounter
        ));
    }

    @Test
    public void testSetFlag() {
        this.logics.setFlag(CELL, true);
        assertTrue(this.logics.isFlagged(CELL));
    }

    @Test
    public void testMultipleSetFlag() {
        this.logics.setFlag(CELL, true);
        this.logics.setFlag(CELL, false);
    }
}
