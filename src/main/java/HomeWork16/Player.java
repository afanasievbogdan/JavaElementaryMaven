package HomeWork16;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    private Scanner howMuchGamesInput;
    private Scanner moveTypeInput;

    public int howMuchGames() {
        System.out.println("How much games you want to play?");
        boolean success = false;
        while (!success) {
            try {
                success = true;
                howMuchGamesInput = new Scanner(System.in);
                return howMuchGamesInput.nextInt();
            } catch (InputMismatchException exception) {
                success = false;
                System.out.println("Wrong input");
            }
        }
        return howMuchGamesInput.nextInt();
    }

    public ShowType showType(){
        System.out.println("What you want to show \"PAPER\", \"ROCK\" or \"SCISSORS\"? If you want to end a game type \"BREAK\"");
        moveTypeInput = new Scanner(System.in);
        String input = moveTypeInput.nextLine();
        switch (input) {
            case "SCISSORS":
                return ShowType.SCISSORS;
            case "PAPER":
                return ShowType.PAPER;
            case "ROCK":
                return ShowType.ROCK;
            case "BREAK":
                return ShowType.BREAK;
            default:
                System.out.println("Wrong input");
                return showType();
        }
    }
}
