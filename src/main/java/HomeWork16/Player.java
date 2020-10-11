package HomeWork16;

import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Player {

    private Scanner howMuchGamesInput;
    private Scanner moveTypeInput;

    ResourceBundle bundle = ResourceBundle.getBundle("language");

    public int howMuchGames() {
        System.out.println(bundle.getString("howMuchGames"));
        boolean success = false;
        while (!success) {
            try {
                success = true;
                howMuchGamesInput = new Scanner(System.in);
                return howMuchGamesInput.nextInt();
            } catch (InputMismatchException exception) {
                success = false;
                System.out.println(bundle.getString("wrongInput"));
            }
        }
        return howMuchGamesInput.nextInt();
    }

    public ShowType showType(){
        System.out.println(bundle.getString("playerShow"));
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
                System.out.println(bundle.getString("wrongInput"));
                return showType();
        }
    }
}
