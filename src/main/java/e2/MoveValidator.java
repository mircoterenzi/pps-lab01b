package e2;

/**
 * Models a validator which tests if a given move is possible.
 */
public interface MoveValidator {

    /**
     * Returns true if the modelled element can be moved from the start to the end position.
     * @param startPosition Represent the coordinates of the start position.
     * @param endPosition Represent the coordinates of the end position.
     * @return true if movement from start to end position is possible.
     */
    boolean test(Pair<Integer, Integer> startPosition, Pair<Integer, Integer> endPosition);
}
