package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    public static final int SIZE = 4;
    public static final Pair<Integer, Integer> PAWN_POSITION = new Pair<>(SIZE - 1, SIZE - 1);
    public static final Pair<Integer, Integer> KINGHT_POSITION = new Pair<>(0, 0);
    private Logics logics;

    @Test
    public void testMoveOutsideBoard() {
        this.logics = new LogicsImpl(SIZE);
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(SIZE, SIZE));
    }

    @Test
    public void testIllegalMove() {
        this.logics = new LogicsImpl(SIZE, PAWN_POSITION, KINGHT_POSITION);
        this.logics.hit(KINGHT_POSITION.getX() + 1, KINGHT_POSITION.getY() + 1);
        assertTrue(this.logics.hasKnight(KINGHT_POSITION.getX(), KINGHT_POSITION.getY()));
    }
}
