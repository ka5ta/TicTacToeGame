package TicTacToeGame;

import TicTacToeGame.Players.BasePlayer;
import TicTacToeGame.Players.Computer;
import TicTacToeGame.Players.Human;
import TicTacToeGame.Players.Player;

import java.util.Arrays;

public class Game {

    Player playerOne;
    Player playerTwo;

    boolean isNextMovePlayerOne = true;


    private BoardSymbol[][] board;

    public Game() {
        this.board = new BoardSymbol[3][3];
        for (BoardSymbol[] row : board) {
            Arrays.fill(row, BoardSymbol.EMPTY);
        }
    }

    public Game(Player player1, Player player2) {
        this();
        this.playerOne = player1;
        this.playerTwo = player2;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            BoardSymbol[] row = board[i];
            System.out.printf("%s | %s | %s\n", row[0], row[1], row[2]);
            if (i < 2) {
                System.out.println("--+---+---");
            }
        }
    }

    public void performPlayerMove(int number, Player player) {
        int column = (number - 1) % 3;
        int row = (number - 1) / 3;
        BoardSymbol existingSymbol = board[row][column];


        if (existingSymbol == BoardSymbol.EMPTY) {
            this.board[row][column] = player.getSymbolChoice();
        } else {
            throw new IllegalArgumentException("This field is not empty, try another field");
        }
    }

    public void oneRound() {
        // which player's turn is it?
        Player nextPlayer = isNextMovePlayerOne ? playerOne : playerTwo;

        while (true) {
            // what is their move?
            int userMove = nextPlayer.nextMove();
            try {
                // perform move
                performPlayerMove(userMove, nextPlayer);
            } catch (IllegalArgumentException e) {
                e.getMessage();
            }
        }
    }

    public void play() {
        printBoard();

        // did someone win?
        while (!gameIsOver()) {
            oneRound();
        }
    }

    private boolean gameIsOver() {
        BoardSymbol firstValue = BoardSymbol.EMPTY;

        //horizontal win
        for (int row = 0; row <3 ; row++) {
            var row_ = board[0];
            board[0][0] == row_[0];


            BoardSymbol[] row_ = board[row];
            firstValue = row_[0];


            firstValue = board[row][0];

            for (int column = 0; column <3 ; column++) {

            }

        }

        //vertical win

        //diagonal win

    }

    public static void main(String[] args) {
        BoardSymbol humanSymbol = Human.userChoiceSymbol();
        Player player1 = new Human(humanSymbol);
        Player player2 = new Computer(humanSymbol.opposite());
        Game game = new Game(player1, player2);
        game.play();

//        game.printBoard();


    }
}
