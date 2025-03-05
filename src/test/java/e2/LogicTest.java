package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    public static final int SIZE = 3;
    public static final Pair<Integer, Integer> PAWN_POSITION = new Pair<>(1, 2);
    public static final Pair<Integer, Integer> KINGHT_POSITION = new Pair<>(0, 0);
    private Logics logics;

    @BeforeEach
    public void setUp() {
        this.logics = new LogicsImpl(SIZE, PAWN_POSITION, KINGHT_POSITION);
    }

    @Test
    public void testMoveOutsideBoard() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(SIZE, SIZE));
    }

    @Test
    public void testHasPawn() {
        assertTrue(this.logics.hasPawn(PAWN_POSITION.getX(), PAWN_POSITION.getY()));
    }

    @Test
    public void testHasKnight() {
        assertTrue(this.logics.hasKnight(KINGHT_POSITION.getX(), KINGHT_POSITION.getY()));
    }

    @Test
    public void testIllegalMove() {
        this.logics.hit(KINGHT_POSITION.getX() + 1, KINGHT_POSITION.getY() + 1);
        assertTrue(this.logics.hasKnight(KINGHT_POSITION.getX(), KINGHT_POSITION.getY()));
    }

    @Test
    public void testEatPawn() {
        assertTrue(this.logics.hit(PAWN_POSITION.getX(), PAWN_POSITION.getY()));
    }
}
