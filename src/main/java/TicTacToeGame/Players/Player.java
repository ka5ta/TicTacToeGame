package TicTacToeGame.Players;

import TicTacToeGame.BoardSymbol;

public interface Player {

    public void nextMove();
    public BoardSymbol getSymbolChoice();

}

