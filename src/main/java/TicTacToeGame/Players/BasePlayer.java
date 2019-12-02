package TicTacToeGame.Players;

import TicTacToeGame.BoardSymbol;

public abstract class BasePlayer {

    protected BoardSymbol symbolChoice;

    public BasePlayer(BoardSymbol symbolChoice) {
        this.symbolChoice = symbolChoice;
    }

    public BoardSymbol getSymbolChoice() {
        return symbolChoice;
    }
}
