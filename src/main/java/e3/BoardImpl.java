package e3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;

public class BoardImpl implements Board {

    private final Random random = new Random();
    private final List<Pair<Integer, Integer>> cells = new ArrayList<>();
    private final List<Pair<Integer, Integer>> mines = new ArrayList<>();
    private final int size;

    private void generateMines(int amount) {
        if (amount != 0) {
            Pair<Integer, Integer> pos = new Pair<>(this.random.nextInt(this.size), this.random.nextInt(this.size));
            if (!this.mines.contains(pos)) {
                this.mines.add(pos);
                amount--;
            }
            generateMines(amount);
        }
    }

    public BoardImpl(int size, int mines) {
        this.size = size;
        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                this.cells.add(new Pair<>(x, y));
            }
        }
        generateMines(mines);
    }

    @Override
    public boolean isMine(Pair<Integer, Integer> pos) {
        return this.mines.contains(pos);
    }

    private boolean areAdjacent(Pair<Integer, Integer> first, Pair<Integer, Integer> second) {
        return abs(first.getX() - second.getX()) <= 1 && abs(first.getY() - second.getY()) <= 1;
        }

    @Override
    public List<Pair<Integer, Integer>> getCellsAdjacentTo(Pair<Integer, Integer> pos) {
        return this.cells.stream()
                .filter(cell -> this.areAdjacent(cell, pos))
                .toList();
    }

    @Override
    public int getAmountMinesAdjacentTo(Pair<Integer, Integer> pos) {
        return (int) this.getCellsAdjacentTo(pos).stream()
                .filter(this::isMine)
                .count();
    }
}
