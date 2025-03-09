package e3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoardImpl implements Board {

    private final Random random = new Random();
    private final List<Cell> cells = new ArrayList<>();
    private final int size;

    private Cell getCellAtPosition(Pair<Integer, Integer> pos) {
        return this.cells.stream()
                .filter(c -> c.equals(new CellImpl(pos)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Trying to get a non-existing cell"));
    }

    private void generateMines(int amount) {
        if (amount != 0) {
            Cell cell = getCellAtPosition(new Pair<>(this.random.nextInt(this.size), this.random.nextInt(this.size)));
            if (!cell.isMine()) {
                cell.setMine(true);
                amount--;
            }
            generateMines(amount);
        }
    }

    public BoardImpl(int size, int mines) {
        if (mines > size * size) {
            throw new IllegalArgumentException("Cannot create a board with more mines than cells");
        }
        this.size = size;
        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                this.cells.add(new CellImpl (new Pair<>(x, y)));
            }
        }
        generateMines(mines);
    }

    @Override
    public boolean isMine(Pair<Integer, Integer> pos) {
        return getCellAtPosition(pos).isMine();
    }

    @Override
    public List<Pair<Integer, Integer>> getCellsAdjacentTo(Pair<Integer, Integer> pos) {
        return this.cells.stream()
                .filter(cell -> cell.isAdjacentTo(getCellAtPosition(pos)))
                .map(Cell::getPosition)
                .toList();
    }

    @Override
    public int getAmountMinesAdjacentTo(Pair<Integer, Integer> pos) {
        return (int) this.getCellsAdjacentTo(pos).stream()
                .filter(this::isMine)
                .count();
    }
}

