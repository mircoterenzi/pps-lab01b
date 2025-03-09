package e3;

import java.util.Optional;

public interface Logics {

    /**
     * Visit the given position, if it is a mine return true.
     * @param pos The position of the position to be checked.
     * @return True if the position is a mine, false otherwise.
     */
    boolean visit(Pair<Integer, Integer> pos);

    /**
     * Tell if the game has been completed.
     * @return True if the game is won, false otherwise.
     */
    boolean isGameCompleted();

    /**
     * Set the flag value for the given position.
     * @param pos The position to be set.
     * @param value The value to set the flag to.
     */
    void setFlag(Pair<Integer, Integer> pos, boolean value);

    /**
     * Return the flag value for the given position.
     * @param pos The position to be checked.
     * @return The flag value.
     */
    boolean isFlagged(Pair<Integer, Integer> pos);

    /**
     * Check if the position is a mine.
     * @param pos The position to be checked.
     * @return True if there is a mine at the given position, false otherwise.
     */
    boolean isMine(Pair<Integer, Integer> pos);

    /**
     * Get, if present, the counter of adjacent mines.
     * @param pos The position of the position.
     * @return An optional containing the counter value if it is present, an empty value otherwise.
     */
    Optional<Integer> getCounter(Pair<Integer, Integer> pos);
}
