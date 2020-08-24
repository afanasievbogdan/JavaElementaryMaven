package HomeWork13;

public class Pair {

    private String lowerElem;
    private String upperElem;

    public Pair(String lowerElem) {
        this.lowerElem = lowerElem;
        this.upperElem = lowerElem.toUpperCase();
    }

    public String getLowerElem() {
        return lowerElem;
    }

    public String getUpperElem() {
        return upperElem;
    }

}
