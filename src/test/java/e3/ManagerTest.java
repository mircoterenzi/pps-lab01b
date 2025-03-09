package e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {

    public static final Pair<Integer, Integer> INITIALIZED_POSITION = new Pair<>(0, 0);
    public static final Pair<Integer, Integer> NON_INITIALIZED_POSITION = new Pair<>(0, 1);
    public static final boolean VALUE = !FlagManager.DEFAULT_VALUE;
    private Manager manager;

    @BeforeEach
    public void setUp() {
        this.manager = new FlagManager();
        this.manager.set(INITIALIZED_POSITION, VALUE);
    }

    @Test
    public void testGetNotInitializedValue() {
        assertEquals(FlagManager.DEFAULT_VALUE, this.manager.getValue(NON_INITIALIZED_POSITION));
    }

    @Test
    public void testGetInitializedValue() {
        assertEquals(VALUE, this.manager.getValue(INITIALIZED_POSITION));
    }
}
