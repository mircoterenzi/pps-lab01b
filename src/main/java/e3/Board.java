package e3;

import java.util.List;

public interface Board {

    /**
     * Check if the cell is a mine.
     * @param pos The position of the cell.
     * @return True if the cell is a mine, false otherwise.
     */
    boolean isMine(Pair<Integer, Integer> pos);

    /**
     * Get a list of all the cells adjacent to the given one.
     * @param pos The position of the cell.
     * @return a list of all the position adjacent to the given cell.
     */
    List<Pair<Integer, Integer>> getCellsAdjacentTo(Pair<Integer, Integer> pos);

    /**
     * Get the amount of adjacent mines to the given cell.
     * @param pos The position of the cell.
     * @return the number of mines adjacent to the cell.
     */
    int getAmountMinesAdjacentTo(Pair<Integer, Integer> pos);
}

