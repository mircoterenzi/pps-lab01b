package e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class LogicTest {

    public static final int SIZE = 5;
    private Logics logics;

    @BeforeEach
    public void setUp() {
        this.logics = new LogicsImpl(SIZE);
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
}
