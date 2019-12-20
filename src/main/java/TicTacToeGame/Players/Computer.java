package TicTacToeGame.Players;

import TicTacToeGame.BoardSymbol;
import TicTacToeGame.Game;

import java.util.Random;

public class Computer extends BasePlayer implements Player {

    public Computer(BoardSymbol oppositeSymbol) {
        super(oppositeSymbol);
    }

    @Override
    public int nextMove(Game game) {

        Random rd = new Random();
        while(true){
            int computerMove = rd.nextInt(9) + 1;
            if(game.symbolFromExistingBoard(computerMove)==BoardSymbol.EMPTY){
                System.out.println("Your opponent made move: "+computerMove);
                return computerMove;
            }
        }
    }
}
