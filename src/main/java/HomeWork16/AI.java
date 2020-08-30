package HomeWork16;

public class AI {

    public ShowType showType(){
        ShowType[] showTypes = {ShowType.ROCK, ShowType.PAPER, ShowType.SCISSORS};
        int random = (int) (Math.random()*3);
        return showTypes[random];
    }

}
