package TicTacToeGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GameGui extends Application {
        @Override
        public void start(Stage stage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("/TicTacToe.fxml"));
            Scene scene = new Scene(root, stage.getWidth(),stage.getHeight());

            stage.setTitle("TicTacToe game");
            stage.setScene(scene);
            stage.show();
        }
    public static void main(String[] args) {
        launch(args);
    }
}
