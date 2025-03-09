package e3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrackerTest {

    public static final Pair<Integer, Integer> TRACKED_POSITION = new Pair<>(0, 0);
    public static final Pair<Integer, Integer> NON_TRACKED_POSITION = new Pair<>(0, 1);
    public static final int NUMBER_TRACKED_POSITION = 5;
    public static final int SINGLE_TRACKED_POSITION = 1;
    private Tracker tracker;

    @BeforeEach
    public void setUp() {
        this.tracker = new VisitTracker();
        this.tracker.track(TRACKED_POSITION);
    }

    @Test
    public void testNotTrackedPosition() {
        assertFalse(this.tracker.isTracked(NON_TRACKED_POSITION));
    }

    @Test
    public void testTrackedPosition() {
        assertTrue(this.tracker.isTracked(TRACKED_POSITION));
    }

    @Test
    public void testAmountOfTrackedPositions() {
        assertEquals(SINGLE_TRACKED_POSITION, this.tracker.getCount());
    }

    @Test
    public void testMultipleTrackPositions() {
        for (int i = 1; i < NUMBER_TRACKED_POSITION; i++) {
            this.tracker.track(new Pair<>(0, i));
        }
        assertEquals(NUMBER_TRACKED_POSITION, this.tracker.getCount());
    }
}