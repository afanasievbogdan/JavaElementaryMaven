package HomeWork16;

public enum ShowType {
    ROCK, PAPER, SCISSORS, BREAK;

    public String checkWhoWins(ShowType showType){
        if (this == showType)
            return "draw";
        else if (this == ROCK)
            return showType == SCISSORS ? "win" : "lost";
        else if (this == PAPER)
            return showType == ROCK ? "win" : "lost";
        else if (this == SCISSORS)
            return showType == PAPER ? "win" : "lost";
        else if (this == BREAK)
            return "break";
        return "0";
    }
}
