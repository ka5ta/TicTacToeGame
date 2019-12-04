package TicTacToeGame.Players;

import TicTacToeGame.BoardSymbol;

public interface Player {

    public int nextMove();
    public BoardSymbol getSymbolChoice();

}

