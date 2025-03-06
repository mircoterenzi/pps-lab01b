package e2;

/**
 * It models the board logics.
 */
public interface Board {

    /**
     * Checks if the position given as input is inside the board boundaries, otherwise throws an exception.
     * @param position The coordinates of the position
     */
    void checkBoundaries(Pair<Integer, Integer> position);

    /**
     * Generate a random position inside the board.
     * @return the coordinates of a random position inside the board.
     */
    Pair<Integer, Integer> randomPosition();
}
