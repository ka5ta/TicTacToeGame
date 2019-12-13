package TicTacToeGame;

import TicTacToeGame.Players.*;

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
        BoardSymbol symbolChoice = playerOne.getSymbolChoice();

        // did someone win?
        while (gameIsOver() == GameStatus.CONTINUE) {
            oneRound();
        }

        if (gameIsOver() == GameStatus.XWIN && symbolChoice == BoardSymbol.X) {
            System.out.println("Player One wins");
        } else if(gameIsOver() == GameStatus.OWIN && symbolChoice == BoardSymbol.O) {
            System.out.println("Player One wins");
        }else if(gameIsOver()==GameStatus.TIE){
            System.out.println("Game is TIE, no one wins");
        }else{
            System.out.println("Player Two wins");
        }
    }


    private GameStatus gameIsOver() {
        BoardSymbol emptySpace = BoardSymbol.EMPTY;
        GameStatus status = GameStatus.TIE;

        //if still empty place on board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == emptySpace) {
                    status = GameStatus.CONTINUE;
                }
            }
        }
        if (status != GameStatus.CONTINUE) {
            return status;
        }

        //horizontal win
        for (int i = 0; i < 3; i++) {
            BoardSymbol firstSymbol = board[i][0];
            BoardSymbol secondSymbol = board[i][1];
            BoardSymbol thirdSymbol = board[i][2];
            if (firstSymbol == secondSymbol && firstSymbol == thirdSymbol) {
                return firstSymbol.toStatus();
            }
        }
        //vertical win
        for (int i = 0; i < 3; i++) {
            BoardSymbol firstSymbol = board[0][i];
            BoardSymbol secondSymbol = board[1][i];
            BoardSymbol thirdSymbol = board[2][i];
            if (firstSymbol == secondSymbol && firstSymbol == thirdSymbol) {
                return firstSymbol.toStatus();
            }
        }
        //diagonal win
        BoardSymbol topLeft = board[0][0];
        BoardSymbol middleMiddle = board[1][1];
        BoardSymbol bottomRight = board[2][2];
        BoardSymbol bottomLeft = board[2][0];
        BoardSymbol topRight = board[0][2];
        if (topLeft == middleMiddle && topLeft == bottomRight) {
            return middleMiddle.toStatus();
        } else if (topRight == middleMiddle && topRight == bottomLeft) {
            return middleMiddle.toStatus();
        } else return GameStatus.CONTINUE;
    }


    public static void main(String[] args) {
        BoardSymbol humanSymbol = Human.userChoiceSymbol();
        Player player1 = new Human(humanSymbol);
        Player player2 = new Computer(humanSymbol.opposite());
        Game game = new Game(player1, player2);
        game.play();



    }
}
