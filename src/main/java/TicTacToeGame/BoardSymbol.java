package TicTacToeGame;

import TicTacToeGame.Players.GameStatus;
import TicTacToeGame.Players.Human;

import java.util.Optional;

public enum BoardSymbol {
    X("X"),
    O("O"),
    EMPTY(" ");

    private final String meaning;

    BoardSymbol(String meaning) {
        this.meaning = meaning;
    }

    public String getMeaning() {
        return meaning;
    }

    @Override
    public String toString() {
        return meaning;
    }

    public BoardSymbol opposite(){
         if(this == BoardSymbol.X){
             return BoardSymbol.O;
         }else{
             return BoardSymbol.X;
         }
    }

    public GameStatus toStatus(){
        if(this==BoardSymbol.X){
            return GameStatus.XWIN;
        }else{
            return GameStatus.OWIN;
        }
    }

    public static BoardSymbol symbolFromString(String userChoseSymbol) {
        switch (userChoseSymbol.toUpperCase()) {
            case "X":
                return BoardSymbol.X;
            case "O":
                return BoardSymbol.O;
        }
        throw new IllegalArgumentException();
    }
}
