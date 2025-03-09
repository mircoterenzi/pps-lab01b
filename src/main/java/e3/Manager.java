package e3;

public interface Manager {

    /**
     * Set a value for the given position.
     * @param pos The position.
     * @param value The value to be set.
     */
    void set(Pair<Integer, Integer> pos, boolean value);

    /**
     * Get the value for a given position.
     * @param pos The position.
     * @return The value associated with the position.
     */
    boolean getValue(Pair<Integer, Integer> pos);
}
