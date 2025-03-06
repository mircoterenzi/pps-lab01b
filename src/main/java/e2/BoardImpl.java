package e2;

import java.util.Random;

public class BoardImpl implements Board {

    private final Random random = new Random();
    private final int size;

    public BoardImpl(int size) {
        this.size = size;
    }

    public void checkBoundaries(Pair<Integer, Integer> position) {
        int x = position.getX();
        int y = position.getY();
        if (x < 0 || y < 0 || x >= this.size || y >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public Pair<Integer, Integer> randomPosition() {
        return new Pair<>(this.random.nextInt(size), this.random.nextInt(size));
    }
}
