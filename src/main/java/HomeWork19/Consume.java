package HomeWork19;

public class Consume extends Thread{

    private final Data data;

    public Consume(Data data) {
        this.data = data;
    }

    private synchronized int consume(){
        if (data.getCurrentData() == data.getMinData()) {
            System.out.println("Data is underdrafted");
        }
        else {
            data.setCurrentData(data.getCurrentData()-1);
        }
        return data.getCurrentData();
    }

    public void run(){
        for (int i = 0; i < 30; i++) {
            System.out.println(currentThread().getName());
            System.out.println(consume());
            System.out.println("=====");
        }
    }
}
