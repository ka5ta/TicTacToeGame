package TicTacToeGame.Players;

import TicTacToeGame.BoardSymbol;

import java.util.Random;

public class Computer extends BasePlayer implements Player {

    public Computer(BoardSymbol oppositeSymbol) {
        super(oppositeSymbol);
    }

    @Override
    public int nextMove() {
        Random rd = new Random();
        int computerMove = rd.nextInt(9) + 1;
        System.out.println("Your opponent made move: "+computerMove);
        return computerMove;
    }
}
