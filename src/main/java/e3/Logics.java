package e3;

import java.util.Optional;

public interface Logics {

    /**
     * Check the cell and, if it is not a mine, calculate the number of adjacent mines
     * (also for adjacent cells if the cell has no mines nearby).
     * @param pos The position of the cell to be checked.
     * @return true if the cell is a mine, false otherwise.
     */
    boolean visit(Pair<Integer, Integer> pos);

    /**
     * Tell if the game has been completed.
     * @return true if the game is won, false otherwise.
     */
    boolean isGameCompleted();

    /**
     * Set flag value for a given cell.
     * @param pos The position of the cell.
     * @param value True if the cell has to be flagged, false otherwise.
     */
    void setFlag(Pair<Integer, Integer> pos, boolean value);

    /**
     * Check if the cell is flagged.
     * @param pos The position of the cell.
     * @return True if the cell is flagged, false otherwise.
     */
    boolean isFlagged(Pair<Integer, Integer> pos);

    /**
     * Check if the cell is a mine.
     * @param pos The position of the cell.
     * @return True if the cell is a mine, false otherwise.
     */
    boolean isMine(Pair<Integer, Integer> pos);

    /**
     * Get, if present, the counter of adjacent mines.
     * @param pos The position of the cell.
     * @return An optional containing the counter value if it is present, an empty value otherwise.
     */
    Optional<Integer> getCounter(Pair<Integer, Integer> pos);
}
