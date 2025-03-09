package e3;

import java.util.List;

public interface Board {

    /**
     * Check if the position is a mine.
     * @param pos The position to be checked.
     * @return True if there is a mine at the given position, false otherwise.
     */
    boolean isMine(Pair<Integer, Integer> pos);

    /**
     * Get a list of all the positions adjacent to the given one.
     * @param pos The central position.
     * @return A list of all the position adjacent to the given one.
     */
    List<Pair<Integer, Integer>> getCellsAdjacentTo(Pair<Integer, Integer> pos);

    /**
     * Get the amount of mines adjacent to the given position.
     * @param pos The central position.
     * @return The number of mines adjacent to the given position.
     */
    int getAmountMinesAdjacentTo(Pair<Integer, Integer> pos);
}

