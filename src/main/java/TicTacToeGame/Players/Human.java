package TicTacToeGame.Players;

import TicTacToeGame.BoardSymbol;

import java.util.Scanner;

public class Human extends BasePlayer implements Player {


    public Human(BoardSymbol symbolChoice) {
        super(symbolChoice);
    }

    @Override
    public void nextMove() {

    }

    public static BoardSymbol userChoiceSymbol() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Choose which symbol you will play with... X/O");
            String userChoseSymbol = sc.next();
            switch (userChoseSymbol.toUpperCase()) {
                case "X":
                    System.out.println("Place \"X\" on the board");
                    return BoardSymbol.X;
                case "O":
                    System.out.println("Place \"O\" on the board");
                    return BoardSymbol.O;
                default:
                    System.out.println("You chose wrong symbol, try again");
            }
        }
    }
}
