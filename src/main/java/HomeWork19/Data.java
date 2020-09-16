package HomeWork19;

public class Data{

    private int currentData;
    private int maxData;
    private int minData;

    public Data(int currentData, int maxData, int minData) {
        if (minData <= currentData || maxData >= currentData) {
            this.currentData = currentData;
            this.maxData = maxData;
            this.minData = minData;
        }else {
            System.out.println("Wrong input");
            System.exit(-1);
        }
    }

    public int getCurrentData() {
        return currentData;
    }

    public int getMaxData() {
        return maxData;
    }

    public int getMinData() {
        return minData;
    }

    public void setCurrentData(int currentData) {
        this.currentData = currentData;
    }
}
