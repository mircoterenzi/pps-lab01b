package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    public static final int SIZE = 5;
    public static final int RANDOM_TEST_NUM = 5;
    private Board board;

    @BeforeEach
    public void setUp() {
        this.board = new BoardImpl(SIZE);
    }

    @Test
    public void testPositionOutsideBoundaries() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.board.checkBoundaries(new Pair<>(SIZE, SIZE)));
    }

    @Test
    public void testPositionInsideBoundaries() {
        assertDoesNotThrow(() -> this.board.checkBoundaries(new Pair<>(SIZE - 1, SIZE - 1)));
    }

    @Test
    public void testRandomPosition() {
        assertDoesNotThrow(() -> {
                    for (int i = 0; i < RANDOM_TEST_NUM; i++) {
                        this.board.checkBoundaries(this.board.randomPosition());
                    }
                }
        );
    }
}
