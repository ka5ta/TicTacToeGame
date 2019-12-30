package TicTacToeGame;

import TicTacToeGame.Players.*;

import java.util.Arrays;

public class Game {

    Player playerOne;
    Player playerTwo;

    boolean isNextMovePlayerOne = true;


    private BoardSymbol[][] board;

/*    public Game() {
        this.board = new BoardSymbol[3][3];
        for (BoardSymbol[] row : board) {
            Arrays.fill(row, BoardSymbol.EMPTY);
        }
    }*/

    public Game(Player player1, Player player2) {
        this.board = new BoardSymbol[3][3];
        for (BoardSymbol[] row : board) {
            Arrays.fill(row, BoardSymbol.EMPTY);

            this.playerOne = player1;
            this.playerTwo = player2;
        }
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

    public BoardSymbol symbolFromExistingBoard(int number){
        int column = (number - 1) % 3;
        int row = (number - 1) / 3;
        return board[row][column];
    }

    public void performPlayerMove(int number, Player player) {
        int column = (number - 1) % 3;
        int row = (number - 1) / 3;
        BoardSymbol existingSymbol = board[row][column];

        if (existingSymbol == BoardSymbol.EMPTY) {
            this.board[row][column] = player.getSymbolChoice();
            isNextMovePlayerOne = !isNextMovePlayerOne;
        } else {
            throw new ExceptionWrongValue();
        }
    }

    public void oneRound() {
        // which player's turn is it?
        Player nextPlayer = getCurrentPlayer();

        while (true) {
            // what is their move?
            int userMove = nextPlayer.nextMove(this);
            try {
                // perform move
                performPlayerMove(userMove, nextPlayer);
                break;
            } catch (ExceptionWrongValue e) {
                System.out.println(e.getMessage());
            }
        }
        printBoard();
    }

    public Player getCurrentPlayer() {
        return isNextMovePlayerOne ? playerOne : playerTwo;
    }

    public void play() {
        printBoard();
        BoardSymbol symbolChoice = playerOne.getSymbolChoice();
        GameStatus gameStatus;

        // did someone win?
        do {
            this.oneRound();
            gameStatus = getGameStatus();
        } while (gameStatus == GameStatus.CONTINUE);

        if (gameStatus == GameStatus.XWIN && symbolChoice == BoardSymbol.X) {
            System.out.println("Player One wins");
        } else if(gameStatus == GameStatus.OWIN && symbolChoice == BoardSymbol.O) {
            System.out.println("Player One wins");
        }else if(gameStatus==GameStatus.TIE){
            System.out.println("Game is TIE, no one wins");
        }else{
            System.out.println("Player Two wins");
        }
    }


    public GameStatus getGameStatus() {

        //horizontal win
        for (int i = 0; i < 3; i++) {
            BoardSymbol winnerSymbol=winnerSymbol(board[i][0],board[i][1],board[i][2]);
            if (winnerSymbol!=null) {
                return winnerSymbol.toStatus();
            }
        }

        //vertical win
        for (int i = 0; i < 3; i++) {
            BoardSymbol winnerSymbol = winnerSymbol(board[0][i],board[1][i],board[2][i]);
            if (winnerSymbol!=null) {
                return winnerSymbol.toStatus();
            }
        }

        //diagonal win
        BoardSymbol winnerSymbolTopLeft = winnerSymbol(board[0][0],board[1][1],board[2][2]);
        BoardSymbol winnerSymbolTopRight = winnerSymbol(board[0][2], board[1][1], board[2][0]);
        if (winnerSymbolTopLeft!=null) {
            return winnerSymbolTopLeft.toStatus();
        } else if (winnerSymbolTopRight!=null) {
            return winnerSymbolTopRight.toStatus();
        }

        //if still empty place on board
        boolean hasEmptySpace = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == BoardSymbol.EMPTY) {
                    hasEmptySpace = true;
                }
            }
        }
        if (!hasEmptySpace) {
            return GameStatus.TIE;
        }

        // still no one wins, game continues
        return GameStatus.CONTINUE;
    }

    public BoardSymbol winnerSymbol(BoardSymbol first, BoardSymbol second, BoardSymbol third){
        if(first == second && first == third && first!=BoardSymbol.EMPTY){
            return first;
        }
        return null;
    }


    public static void main(String[] args) {
        BoardSymbol humanSymbol = Human.userChoiceSymbol();
        Player player1 = new Human(humanSymbol);
        Player player2 = new Computer(humanSymbol.opposite());
        Game game = new Game(player1, player2);
        game.play();
    }
}
