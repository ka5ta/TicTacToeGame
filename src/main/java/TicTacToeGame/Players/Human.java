package TicTacToeGame.Players;

import TicTacToeGame.BoardSymbol;

import java.util.Scanner;

public class Human extends BasePlayer implements Player {


    public Human(BoardSymbol symbolChoice) {
        super(symbolChoice);
    }

    @Override
    public int nextMove() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Pick number from the board from 1-9");
            int userPick = sc.nextInt();
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
