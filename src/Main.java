import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Board board = new Board();

        for (int i = 0; i < 9; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < 9; j++) {
                if (line.charAt(j) == '0') {
                    board.setValue(i, j, new Cell(i, j));
                } else {
                    board.setValue(i, j, new Cell(i, j, line.charAt(j) - '0'));
                }
            }
        }

        board.printBoard();
        board.solve();
        System.out.println("\n\n\nSolved Cells: " + board.getSolved());
        board.printBoard();
    }
}