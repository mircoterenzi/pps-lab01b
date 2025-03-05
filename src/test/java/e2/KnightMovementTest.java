package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightMovementTest {

    public static final Pair<Integer, Integer> POSITION = new Pair<>(0, 0);
    private MoveValidator validator;

    @BeforeEach
    public void setUp() {
        this.validator = new KnightMoveValidator();
    }

    @Test
    public void testIllegalMovement() {
        assertFalse(validator.test(POSITION, new Pair<>(POSITION.getX() + 1, POSITION.getY() + 1)));
    }

    @Test
    public void testLegalMovement() {
        assertTrue(validator.test(POSITION, new Pair<>(POSITION.getX() + 2, POSITION.getY() + 1)));
    }
}
