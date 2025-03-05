package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    public static final int SIZE = 2;
    private Logics logics;

    @Test
    public void testMoveOutsideBoard() {
        this.logics = new LogicsImpl(SIZE);
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(SIZE, SIZE));
    }
}
