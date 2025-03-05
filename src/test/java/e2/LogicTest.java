package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    public static final int SIZE = 3;
    public static final Pair<Integer, Integer> PAWN_POSITION = new Pair<>(1, 2);
    public static final Pair<Integer, Integer> KNIGHT_POSITION = new Pair<>(0, 0);
    private Logics logics;

    @BeforeEach
    public void setUp() {
        this.logics = new LogicsImpl(
                SIZE,
                PAWN_POSITION.getX(),
                PAWN_POSITION.getY(),
                KNIGHT_POSITION.getX(),
                KNIGHT_POSITION.getY()
        );
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
        assertTrue(this.logics.hasKnight(KNIGHT_POSITION.getX(), KNIGHT_POSITION.getY()));
    }

    @Test
    public void testIllegalMove() {
        this.logics.hit(KNIGHT_POSITION.getX() + 1, KNIGHT_POSITION.getY() + 1);
        assertTrue(this.logics.hasKnight(KNIGHT_POSITION.getX(), KNIGHT_POSITION.getY()));
    }

    @Test
    public void testEatPawn() {
        assertTrue(this.logics.hit(PAWN_POSITION.getX(), PAWN_POSITION.getY()));
    }
}
