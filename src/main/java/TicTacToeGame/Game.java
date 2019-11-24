package TicTacToeGame;

import java.util.Arrays;

public class Game {


    private Options[][] board;

    public Game() {
        this.board = new Options[3][3];
        for (Options[] row: board) {
            Arrays.fill(row,Options.EMPTY);
        }
    }

    public void printBoard() {

        for (int i = 0; i < 3; i++) {
            Options[] row = board[i];
            System.out.printf("%s | %s | %s\n", row[0], row[1], row[2]);
            if (i < 2) {
                System.out.println("--+---+---");
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.printBoard();
    }
}
