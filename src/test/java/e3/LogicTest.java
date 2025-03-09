package e3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    public static final Pair<Integer, Integer> FIRST_POSITION = new Pair<>(0, 0);
    public static final int DEFAULT_SIZE = 5;
    public static final int FULLY_ADJACENT_SIZE = 2;
    public static final int NO_MINES = 0;
    public static final int SINGLE_MINE = 1;
    public static final int DEFAULT_MINES = 3;

    private List<Pair<Integer, Integer>> getPositionListGivenSize(int size) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                list.add(new Pair<>(x, y));
            }
        }
        return list;
    }

    @Test
    public void testInitiallyNotFlagged() {
        Logics logics = new LogicsImpl(DEFAULT_SIZE, DEFAULT_MINES);
        assertFalse(getPositionListGivenSize(DEFAULT_SIZE).stream().anyMatch(logics::isFlagged));
    }

    @Test
    public void testInitiallyGameNotWon() {
        Logics logics = new LogicsImpl(DEFAULT_SIZE, DEFAULT_MINES);
        assertFalse(logics.isGameCompleted());
    }

    @Test
    public void testRightMinesAmountGeneration() {
        Logics logics = new LogicsImpl(DEFAULT_SIZE, DEFAULT_MINES);
        assertEquals(DEFAULT_MINES, getPositionListGivenSize(DEFAULT_SIZE).stream()
                .filter(logics::isMine)
                .count()
        );
    }

    @Test
    public void testSetFlag() {
        Logics logics = new LogicsImpl(DEFAULT_SIZE, DEFAULT_MINES);
        logics.setFlag(FIRST_POSITION, true);
        assertTrue(logics.isFlagged(FIRST_POSITION));
    }

    @Test
    public void testMultipleSetFlag() {
        Logics logics = new LogicsImpl(DEFAULT_SIZE, DEFAULT_MINES);
        logics.setFlag(FIRST_POSITION, true);
        logics.setFlag(FIRST_POSITION, false);
        assertFalse(logics.isFlagged(FIRST_POSITION));
    }

    @Test
    public void testGetTrueIfVisitMine() {
        Logics logics = new LogicsImpl(DEFAULT_SIZE, DEFAULT_MINES);
        Pair<Integer, Integer> pos = getPositionListGivenSize(DEFAULT_SIZE).stream()
                .filter(logics::isMine)
                .toList()
                .getFirst();
        assertTrue(logics.visit(pos));
    }

    private Pair<Integer, Integer> getNotMine(Logics logics, int size) {
        return getPositionListGivenSize(size).stream()
                .filter(Predicate.not(logics::isMine))
                .toList()
                .getFirst();
    }

    @Test
    public void testGetFalseIfVisitNotMinePosition() {
        Logics logics = new LogicsImpl(DEFAULT_SIZE, DEFAULT_MINES);
        Pair<Integer, Integer> pos = getNotMine(logics, DEFAULT_SIZE);
        assertFalse(logics.visit(pos));
    }

    @Test
    public void testGetCounterForVisitedPosition() {
        Logics logics = new LogicsImpl(FULLY_ADJACENT_SIZE, SINGLE_MINE);
        Pair<Integer, Integer> pos = getNotMine(logics, FULLY_ADJACENT_SIZE);
        logics.visit(pos);
        assertEquals(Optional.of(SINGLE_MINE), logics.getCounter(pos));
    }

    @Test
    public void testEmptyIfPositionIsNotVisited() {
        Logics logics = new LogicsImpl(FULLY_ADJACENT_SIZE, SINGLE_MINE);
        Pair<Integer, Integer> pos = getNotMine(logics, FULLY_ADJACENT_SIZE);
        assertEquals(Optional.empty(), logics.getCounter(pos));
    }

    @Test
    public void testVisitAdjacentIfCounterIsZero() {
        Logics logics = new LogicsImpl(FULLY_ADJACENT_SIZE, NO_MINES);
        logics.visit(FIRST_POSITION);
        assertTrue(getPositionListGivenSize(FULLY_ADJACENT_SIZE).stream()
                .allMatch(pos -> logics.getCounter(pos).isPresent())
        );
    }

    @Test
    public void testVictoryIfAllRightPositionsAreVisited() {
        Logics logics = new LogicsImpl(DEFAULT_SIZE, DEFAULT_MINES);
        getPositionListGivenSize(DEFAULT_SIZE).forEach(pos -> {
            if (!logics.isMine(pos)) {
                logics.visit(pos);
            }
        });
        assertTrue(logics.isGameCompleted());
    }
}

