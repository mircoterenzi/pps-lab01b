package e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    public static final Pair<Integer, Integer> POS = new Pair<>(0, 0);
    public static final Pair<Integer, Integer> NOT_ADJACENT_POS = new Pair<>(5, 2);
    public static final Pair<Integer, Integer> ADJACENT_POS = new Pair<>(1, -1);
    private Cell cell;

    @BeforeEach
    public void setUp() {
        this.cell = new CellImpl(POS);
    }

    @Test
    public void testInitiallyNotMine() {
        assertFalse(this.cell.isMine());
    }

    @Test
    public void testNoChangeIfSetToCurrentValue() {
        this.cell.setMine(false);
        assertFalse(this.cell.isMine());
    }

    @Test
    public void testSetMineValue() {
        this.cell.setMine(true);
        assertTrue(this.cell.isMine());
    }

    @Test
    public void testReturnPosition() {
        assertEquals(POS, this.cell.getPosition());
    }

    @Test
    public void testNotAdjacentToSelf() {
        assertFalse(this.cell.isAdjacentTo(this.cell));
    }

    @Test
    public void testNotAdjacent() {
        assertFalse(this.cell.isAdjacentTo(new CellImpl(NOT_ADJACENT_POS)));
    }

    @Test
    public void testAdjacent() {
        assertTrue(this.cell.isAdjacentTo(new CellImpl(ADJACENT_POS)));
    }
}
