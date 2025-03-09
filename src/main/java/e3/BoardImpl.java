package e3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class BoardImpl implements Board {

    private final List<Cell> cells = new ArrayList<>();

    private Cell getCellAtPosition(Pair<Integer, Integer> pos) {
        return this.cells.stream()
                .filter(c -> c.equals(new CellImpl(pos)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Trying to get a non-existing cell"));
    }

    private void generateCells(int size) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                this.cells.add(new CellImpl (new Pair<>(x, y)));
            }
        }
    }

    private void generateMines(int amount) {
        Random random = new Random();
        List<Cell> notMineCells = new ArrayList<>(this.cells.stream()
                .filter(Predicate.not(Cell::isMine))
                .toList());
        if (notMineCells.size() < amount) {
            throw new IllegalArgumentException("Cannot create a board with more mines than cells");
        }
        while (amount != 0) {
            Cell cell = notMineCells.remove(random.nextInt(notMineCells.size()));
            cell.setMine(true);
            amount--;
        }
    }

    public BoardImpl(int size, int mines) {
        generateCells(size);
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

