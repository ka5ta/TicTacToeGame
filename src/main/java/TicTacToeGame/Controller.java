package TicTacToeGame;

import TicTacToeGame.Players.Computer;
import TicTacToeGame.Players.GameStatus;
import TicTacToeGame.Players.Human;
import TicTacToeGame.Players.Player;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;

public class Controller{

    @FXML private Button topLeft;
    @FXML private Button topMiddle;
    @FXML private Button topRight;
    @FXML private Button leftMiddle;
    @FXML private Button middleMiddle;
    @FXML private Button rightMiddle;
    @FXML private Button bottomLeft;
    @FXML private Button bottomMiddle;
    @FXML private Button bottomRight;
    @FXML private Label textLabel;
    @FXML private GridPane gridPane;

    private Game game;


    @FXML
    public void initialize() {
        System.out.println("Hello");
        gridPane.setDisable(true);

        // todo computer vs computer
        // todo label doesn't show whose turn it is
        // todo computer to press button with delay
    }

    @FXML
    private void newGameStarting(ActionEvent event) {
        Object object = event.getSource();
        MenuItem menuItem = (MenuItem) object;
        Player player1;
        Player player2;

        String id = menuItem.getId();
        switch(id){
            case "pvc":
                player1 = new Human(BoardSymbol.X);
                player2 = new Computer(BoardSymbol.O);
                break;
            case "pvp":
                player1 = new Human(BoardSymbol.X);
                player2 = new Human(BoardSymbol.O);
                break;
            case "cvc":
                player1 = new Computer(BoardSymbol.X);
                player2 = new Computer(BoardSymbol.O);
                break;
            default:
               throw new IllegalArgumentException();
        }

        game = new Game(player1,player2);
        gridPane.setDisable(false);
        clearBoard();
    }

    private void clearBoard() {
        for (int i = 0; i <gridPane.getChildren().size() ; i++) {
            Button button = (Button)gridPane.getChildren().get(i);
            button.setText("");
        }

        /*for (Node node: gridPane.getChildren()) {
            Button button = (Button) node;
            button.setText("");
        }*/
    }

    @FXML
    private void handleClick(ActionEvent event) {
        Object object = event.getSource();
        if (object instanceof Button) {
            Button button = (Button) object;

            int col = GridPane.getColumnIndex(button);
            int row = GridPane.getRowIndex(button);

            int chosenField = positionNumber(row, col);
            Player player = game.getCurrentPlayer();
            game.performPlayerMove(chosenField, player);
            button.setText(player.getSymbolChoice().toString());
            GameStatus gameStatus = gameOver();

            if(gameStatus!=GameStatus.CONTINUE){
                return;
            }
            if (game.getCurrentPlayer() instanceof Computer) {
                computerMove();
            }
            gameOver();
        }
    }

    private int positionNumber(int row, int col){
        return row*3+col+1;
    }

    private void computerMove(){
        Player computer = game.getCurrentPlayer();
        int computerMove = computer.nextMove(game);

        game.performPlayerMove(computerMove,computer);
        Button button = (Button) gridPane.getChildren().get(computerMove - 1);
        button.setText(computer.getSymbolChoice().getMeaning());
    }

    private GameStatus gameOver(){
        GameStatus gameStatus = game.getGameStatus();
        if(gameStatus==GameStatus.CONTINUE){
            return gameStatus;
        }

        switch(gameStatus){
            case XWIN:
                textLabel.setText("Player 1 wins");
          break;
            case OWIN:
                textLabel.setText("Player 2 wins");
              break;
            case TIE:
                textLabel.setText("That is a Tie");
                break;
        }
        gridPane.setDisable(true);
        return gameStatus;
    }
}
