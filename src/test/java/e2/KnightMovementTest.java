package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightMovementTest {
    public static final Pair<Integer, Integer> POSITION = new Pair<>(0, 0);

    @Test
    public void testIllegalMovement() {
        MoveValidator validator = new KnightMoveValidator();
        assertFalse(validator.test(POSITION, new Pair<>(POSITION.getX() + 1, POSITION.getY() + 1)));
    }
}
