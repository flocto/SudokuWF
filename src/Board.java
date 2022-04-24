import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class Board {
    private Cell[][] board;
    private HashMap<Integer, ArrayList<Cell>> rowMap;
    private HashMap<Integer, ArrayList<Cell>> colMap;
    private HashMap<Integer, ArrayList<Cell>> boxMap;
    int solved = 0;
    int total = 81;

    public Board() {
        this.board = new Cell[9][9];
        this.rowMap = new HashMap<Integer, ArrayList<Cell>>();
        this.colMap = new HashMap<Integer, ArrayList<Cell>>();
        this.boxMap = new HashMap<Integer, ArrayList<Cell>>();
    }

    public Cell[][] getBoard() {
        return board;
    }

    public Cell getValue(int row, int col) {
        return this.board[row][col];
    }

    public void setValue(int row, int col, Cell value) {
        this.board[row][col] = value;
        ArrayList<Cell> rowList = this.rowMap.getOrDefault(row, new ArrayList<Cell>());
        rowList.add(value);
        this.rowMap.put(row, rowList);
        ArrayList<Cell> colList = this.colMap.getOrDefault(col, new ArrayList<Cell>());
        colList.add(value);
        this.colMap.put(col, colList);
        ArrayList<Cell> boxList = this.boxMap.getOrDefault(row / 3 * 3 + col / 3, new ArrayList<Cell>());
        boxList.add(value);
        this.boxMap.put(row / 3 * 3 + col / 3, boxList);
        if (value.getValue() != 0) {
            this.total--;
        }
    }

    private int getBoxIndex(int row, int col) {
        return (row / 3) * 3 + col / 3;
    }

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(this.board[i][j].getValue() + " ");
            }
            System.out.println();
        }
    }

    public void solve() {
        ArrayDeque<Cell> alreadyCollapsed = new ArrayDeque<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j].collapsed) {
                    alreadyCollapsed.add(board[i][j]);
                }
            }
        }

        while (!alreadyCollapsed.isEmpty()) {
            Cell cell = alreadyCollapsed.poll();
            int row = cell.getRow();
            int col = cell.getCol();
            int box = getBoxIndex(row, col);
            int value = cell.getValue();
            ArrayList<Cell> rowCells = rowMap.get(row);
            ArrayList<Cell> colCells = colMap.get(col);
            ArrayList<Cell> boxCells = boxMap.get(box);

            for (Cell rowCell : rowCells) {
                if (rowCell.collapsed) {
                    continue;
                }
                rowCell.removeState(value);
                if (rowCell.getStateSize() == 1) {
                    solved++;
                    rowCell.collapse();
                    alreadyCollapsed.add(rowCell);
                }
            }

            for (Cell colCell : colCells) {
                if (colCell.collapsed) {
                    continue;
                }
                colCell.removeState(value);
                if (colCell.getStateSize() == 1) {
                    solved++;
                    colCell.collapse();
                    alreadyCollapsed.add(colCell);
                }
            }

            for (Cell boxCell : boxCells) {
                if (boxCell.collapsed) {
                    continue;
                }
                boxCell.removeState(value);
                if (boxCell.getStateSize() == 1) {
                    solved++;
                    boxCell.collapse();
                    alreadyCollapsed.add(boxCell);
                }
            }

        }
    }

    public int getSolved() {
        return this.solved;
    }

    public int getTotal() {
        return this.total;
    }
}
