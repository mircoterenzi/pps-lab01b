package e3;

import java.util.ArrayList;
import java.util.List;

public class VisitTracker implements Tracker {

    private final List<Pair<Integer, Integer>> elements = new ArrayList<>();

    @Override
    public boolean isTracked(Pair<Integer, Integer> pos) {
        return this.elements.contains(pos);
    }

    @Override
    public void track(Pair<Integer, Integer> pos) {
        this.elements.add(pos);
    }

    @Override
    public int getCount() {
        return this.elements.size();
    }
}
