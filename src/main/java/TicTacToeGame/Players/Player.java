package TicTacToeGame.Players;

import TicTacToeGame.BoardSymbol;
import TicTacToeGame.Game;

public interface Player {

    public int nextMove(Game game);
    public BoardSymbol getSymbolChoice();

}

