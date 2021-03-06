package TicTacToeGame.Players;

import TicTacToeGame.BoardSymbol;
import TicTacToeGame.Game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Human extends BasePlayer implements Player {


    public Human(BoardSymbol symbolChoice) {
        super(symbolChoice);
    }

    @Override
    public int nextMove(Game game) {

        int userPick;

        while (true) {
            System.out.println("Pick number from the board from 1-9");
            try {
                Scanner sc = new Scanner(System.in);
                userPick = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Why you entered text when I said number?");
                continue;
            }
            if (userPick < 10 && userPick > 0) {
                return userPick;
            }else{
                System.out.println("This is wrong, try again...idiota!");
            }
        }
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
            }catch(ExceptionWrongValue e){
                System.out.println(e.getMessage());
            }
        }
    }


}
