package e3;

public interface Tracker {

    /**
     * Check if a position is tracked.
     * @param pos The position to check.
     * @return True if the position is tracked, false otherwise.
     */
    boolean isTracked(Pair<Integer, Integer> pos);

    /**
     * Track a position.
     * @param pos The position to track.
     */
    void track(Pair<Integer, Integer> pos);

    /**
     * Get the number of tracked positions.
     * @return The number of tracked positions.
     */
    int getCount();
}
