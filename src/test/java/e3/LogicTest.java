package e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    public static final int SIZE = 5;
    public static final int MINES = 3;
    public static final Pair<Integer, Integer> CELL = new Pair<>(0,0);
    private Logics logics;

    @BeforeEach
    public void setUp() {
        this.logics = new LogicsImpl(SIZE, MINES);
    }

    private List<Pair<Integer, Integer>> getCellList(int size) {
        List<Pair<Integer, Integer>> cells = new ArrayList<>();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                cells.add(new Pair<>(x, y));
            }
        }
        return cells;
    }

    private <X> X checkOnEachCell(X initialValue, BiFunction<Pair<Integer, Integer>, X, X> updateFunction) {
        X value = initialValue;
        for (Pair<Integer, Integer> cell : getCellList(SIZE)) {
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
        assertEquals(MINES, checkOnEachCell(
                0,
                (cell, mineCounter) ->
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

    @Test
    public void testGetTrueIfVisitMineCell() {
        Pair<Integer, Integer> pos = getCellList(SIZE).stream()
                .filter(cell -> this.logics.isMine(cell))
                .toList()
                .getFirst();
        assertTrue(this.logics.visit(pos));
    }

    private Pair<Integer, Integer> getNotMine(int size) {
        return getCellList(size).stream()
                .filter(cell -> !this.logics.isMine(cell))
                .toList()
                .getFirst();
    }

    @Test
    public void testGetFalseIfVisitNotMineCell() {
        Pair<Integer, Integer> pos = getNotMine(SIZE);
        assertFalse(this.logics.visit(pos));
    }

    @Test
    public void testGetCounterForVisitedCell() {
        this.logics = new LogicsImpl(2, 1); // Overrides the BeforeEach declaration
        Pair<Integer, Integer> pos = getNotMine(2);
        this.logics.visit(pos);
        assertEquals(Optional.of(1), this.logics.getCounter(pos));
    }

    @Test
    public void testEmptyIfCellIsNotVisited() {
        this.logics = new LogicsImpl(2, 1); // Overrides the BeforeEach declaration
        Pair<Integer, Integer> pos = getNotMine(2);
        assertEquals(Optional.empty(), this.logics.getCounter(pos));
    }

    @Test
    public void testVisitAdjacentIfCounterIsZero() {
        this.logics = new LogicsImpl(2, 0); // Overrides the BeforeEach declaration
        this.logics.visit(CELL);
        assertAll(
                () -> assertTrue(this.logics.getCounter(new Pair<>(0, 0)).isPresent()),
                () -> assertTrue(this.logics.getCounter(new Pair<>(0, 1)).isPresent()),
                () -> assertTrue(this.logics.getCounter(new Pair<>(1, 0)).isPresent()),
                () -> assertTrue(this.logics.getCounter(new Pair<>(1, 0)).isPresent())
        );
    }

    @Test
    public void testVictoryIfAllRightCellsAreVisited() {
        getCellList(SIZE).forEach(cell -> {
            if (!this.logics.isMine(cell)) {
                this.logics.visit(cell);
            }
        });
        assertTrue(this.logics.isGameCompleted());
    }
}

