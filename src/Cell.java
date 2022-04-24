import java.util.HashSet;

public class Cell {
    HashSet<Integer> states;
    int value;
    boolean collapsed;
    int row;
    int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        value = 0;
        collapsed = false;
        this.states = new HashSet<Integer>();
        for (int i = 1; i <= 9; i++) {
            this.states.add(i);
        }
    }

    public Cell(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
        collapsed = true;
        this.states = null;
    }

    public void removeState(int state) {
        this.states.remove(state);
    }

    public void collapse(){
        this.collapsed = true;
        System.out.println(this.states);
        this.value = this.states.iterator().next();
        this.states = null;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public HashSet<Integer> getStates() {
        return states;
    }

    public int getStateSize() {
        return states.size();
    }

    public int getValue() {
        return value;
    }
}
