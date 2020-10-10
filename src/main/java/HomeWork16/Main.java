package HomeWork16;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    private Player player;
    private AI ai;
    private int playerScore;
    private int aiScore;
    private int drawScore;
    private int numOfGames;

    private static final Logger log = LogManager.getLogger(Main.class);

    public Main() {
        player = new Player();
        ai = new AI();
        playerScore = 0;
        aiScore = 0;
        numOfGames = 0;
    }

    public int startGame(){
        int howMuchGames = player.howMuchGames();
        log.info("Player choose " + howMuchGames + " games to play");
        return howMuchGames;
    }

    public void playGame(int howMuchGames) throws IOException {
        ShowType playerMove = player.showType();
        log.info("Player shows " + playerMove);
        ShowType aiMove = ai.showType();
        log.info("AI shows " + aiMove);

        if (playerMove != ShowType.BREAK) {
            System.out.println("AI shows " + aiMove + ".");
        }
        String checkWhoWins = playerMove.checkWhoWins(aiMove);
        switch (checkWhoWins) {
            case "draw":
                log.info("It's a draw");
                System.out.println("IT'S A DRAW!\n");
                drawScore++;
                break;
            case "win":
                log.info("User win");
                System.out.println(playerMove + " beats " + aiMove + ". YOU WIN!\n");
                playerScore++;
                break;
            case "lost":
                log.info("User lost");
                System.out.println(aiMove + " beats " + playerMove + ". YOU LOST.\n");
                aiScore++;
                break;
            case "break":
                log.warn("User break the game");
                log.info("User played " + numOfGames + " games");
                log.info((howMuchGames - numOfGames) + " games left");
                log.info("Player score = " + playerScore);
                log.info("AI score = " + aiScore);
                if (playerScore > aiScore)
                    log.error("PLAYER WON!");
                else log.error("YOU LOST, AI WON");
                saveResultToFile();
                System.exit(0);
        }
        numOfGames++;
        if (numOfGames != howMuchGames)
            playGame(howMuchGames);
        else {
            log.warn("Game ends");
            log.info("User played " + numOfGames + " games");
            log.info((howMuchGames - numOfGames) + " games left");
            log.info("Player score = " + playerScore);
            log.info("AI score = " + aiScore);
            if (playerScore > aiScore)
                log.error("PLAYER WON!");
            else log.error("YOU LOST, AI WON");
            saveResultToFile();
        }
    }

    public void saveResultToFile() throws IOException {
        System.out.printf("You have played %d games, you won %d times, super smart AI won %d times, draw was %d times.\n", numOfGames, playerScore, aiScore, drawScore);
        if (playerScore > aiScore)
            System.out.println("CONGRATULATION! YOU WIN!");
        else System.out.println("SORRY, THIS TIME YOU LOST");

        System.out.println("\nResults has saved to file!");

        FileWriter fileWriter = new FileWriter("C:/Users/MSI/IdeaProjects/JavaElementaryMaven/src/main/java/HomeWork16/file.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.printf("You have played %d games, you won %d times, super smart AI won %d times, draw was %d times.\n", numOfGames, playerScore, aiScore, drawScore);
        if (playerScore > aiScore)
            printWriter.print("CONGRATULATION! YOU WON!");
        else printWriter.print("SORRY, THIS TIME YOU LOST");
        printWriter.print("\n\n");
        printWriter.close();
        }

    public static void main(String[] args) throws IOException {
        log.warn("The game starts");
        Main newGame = new Main();

        newGame.playGame(newGame.startGame());
    }
}
