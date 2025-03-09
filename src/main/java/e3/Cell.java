package e3;

public interface Cell {

    /**
     * Check if the cell is a mine.
     * @return True if the cell is a mine, false otherwise.
     */
    boolean isMine();

    /**
     * Set mine value.
     * @param value True if the cell is a mine, false otherwise.
     */
    void setMine(boolean value);

    /**
     * Get the position of the cell.
     * @return The position of the cell.
     */
    Pair<Integer, Integer> getPosition();

    /**
     * Check whether is adjacent at the given cell or not.
     * @param cell The other cell.
     * @return True if the cell is adjacent to the given one, false otherwise.
     */
    boolean isAdjacentTo(Cell cell);
}
