package e3;

import java.util.HashMap;
import java.util.Map;

public class FlagManager implements Manager {

    public static final boolean DEFAULT_VALUE = false;
    private final Map<Pair<Integer, Integer>, Boolean> values = new HashMap<>();

    @Override
    public void set(Pair<Integer, Integer> pos, boolean value) {
        this.values.put(pos, value);
    }

    @Override
    public boolean getValue(Pair<Integer, Integer> pos) {
        if (!this.values.containsKey(pos)) {
            this.values.put(pos, DEFAULT_VALUE);
        }
        return this.values.get(pos);
    }
}
