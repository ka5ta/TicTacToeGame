package TicTacToeGame.Players;

import TicTacToeGame.BoardSymbol;

import java.util.Scanner;

public class Human extends BasePlayer implements Player {


    public Human(BoardSymbol symbolChoice) {
        super(symbolChoice);
    }

    @Override
    public void nextMove() {
        Scanner sc = new Scanner(System.in);

        System.out.println();

    }

    public static BoardSymbol userChoiceSymbol() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Choose which symbol you will play with... X/O");
            String userChoice = sc.next();
            try{
                BoardSymbol userChoiceSymbol = BoardSymbol.symbolFromString(userChoice);
                System.out.println("You are playing with "+userChoiceSymbol);
                return userChoiceSymbol;
            }catch(IllegalArgumentException e){
                System.out.println("Wrong choice, try again..idiota!");
            }
        }
    }


}
