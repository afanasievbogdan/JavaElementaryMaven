package HomeWork16;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

public class Main {
    private Player player;
    private AI ai;
    private int playerScore;
    private int aiScore;
    private int drawScore;
    private int numOfGames;

    ResourceBundle bundle = ResourceBundle.getBundle("language");
    private static final Logger log = LogManager.getLogger(Main.class);

    public Main() {
        player = new Player();
        ai = new AI();
        playerScore = 0;
        aiScore = 0;
        numOfGames = 0;
        log.warn(bundle.getString("log_gameStarts"));
    }

    public int startGame(){
        int howMuchGames = player.howMuchGames();
        log.info(bundle.getString("log_playerChoose") + howMuchGames + " " + bundle.getString("log_games"));
        return howMuchGames;
    }

    public void playGame(int howMuchGames) throws IOException {
        ShowType playerMove = player.showType();
        log.info(bundle.getString("playerShows") + playerMove);
        ShowType aiMove = ai.showType();
        log.info(bundle.getString("aiShows") + aiMove);

        if (playerMove != ShowType.BREAK) {
            System.out.println(bundle.getString("playerShows") + playerMove + ".");
            System.out.println(bundle.getString("aiShows") + aiMove + ".");
        }
        String checkWhoWins = playerMove.checkWhoWins(aiMove);
        switch (checkWhoWins) {
            case "draw":
                log.info(bundle.getString("log_draw"));
                System.out.println(bundle.getString("draw") + "\n");
                drawScore++;
                break;
            case "win":
                log.info(bundle.getString("log_win"));
                System.out.println(playerMove + " " + bundle.getString("beats") + " " + aiMove + "." + bundle.getString("win") + "\n");
                playerScore++;
                break;
            case "lost":
                log.info(bundle.getString("log_lost"));
                System.out.println(aiMove + " " + bundle.getString("beats") + " " + playerMove + "." + bundle.getString("lost") + "\n");
                aiScore++;
                break;
            case "break":
                log.warn(bundle.getString("log_break"));
                log.info(bundle.getString("log_gamesPlayed") + numOfGames + bundle.getString("log_gamesPlayed2"));
                log.info((howMuchGames - numOfGames) + bundle.getString("log_gamesLeft"));
                log.info(bundle.getString("log_playerScore") + playerScore);
                log.info(bundle.getString("log_aiScore") + aiScore);
                if (playerScore > aiScore)
                    log.error(bundle.getString("log_playerWon"));
                else log.error(bundle.getString("log_aiWon"));
                saveResultToFile();
                System.exit(0);
        }
        numOfGames++;
        if (numOfGames != howMuchGames)
            playGame(howMuchGames);
        else {
            log.warn(bundle.getString("log_gameEnds"));
            log.info(bundle.getString("log_gamesPlayed") + numOfGames + bundle.getString("log_gamesPlayed2"));
            log.info((howMuchGames - numOfGames) + bundle.getString("log_gamesLeft"));
            log.info(bundle.getString("log_playerScore") + playerScore);
            log.info(bundle.getString("log_aiScore") + aiScore);
            if (playerScore > aiScore)
                log.error(bundle.getString("log_playerWon"));
            else log.error(bundle.getString("log_aiWon"));
            saveResultToFile();
        }
    }

    public void saveResultToFile() throws IOException {
        System.out.printf(bundle.getString("result") + "\n", numOfGames, playerScore, aiScore, drawScore);
        if (playerScore > aiScore)
            System.out.println(bundle.getString("congrats"));
        else System.out.println(bundle.getString("sorry"));

        System.out.println(bundle.getString("saveToFile"));

        FileWriter fileWriter = new FileWriter("C:/Users/MSI/IdeaProjects/JavaElementaryMaven/src/main/java/HomeWork16/file.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.printf(bundle.getString("result"), numOfGames, playerScore, aiScore, drawScore);
        if (playerScore > aiScore)
            printWriter.print(bundle.getString("congrats"));
        else printWriter.print(bundle.getString("sorry"));
        printWriter.print("\n\n");
        printWriter.close();
        }

    public static void main(String[] args) throws IOException {
        Main newGame = new Main();

        newGame.playGame(newGame.startGame());
    }
}
