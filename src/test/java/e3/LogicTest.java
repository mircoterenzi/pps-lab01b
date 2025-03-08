package e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    public void testInitiallyNotFlagged() {
        boolean isAtLeastOneFlagged = false;
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                Pair<Integer, Integer> pos = new Pair<>(x, y);
                isAtLeastOneFlagged = isAtLeastOneFlagged || this.logics.isFlagged(pos);
            }
        }
        assertFalse(isAtLeastOneFlagged);
    }

    @Test
    public void testInitiallyGameNotWon() {
        assertFalse(this.logics.isGameCompleted());
    }

    @Test
    public void testRightMinesAmountGeneration() {
        int mines = 0;
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                Pair<Integer, Integer> pos = new Pair<>(x, y);
                if (this.logics.isMine(pos)) {
                    mines++;
                }
            }
        }
        assertEquals(MINES, mines);
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
