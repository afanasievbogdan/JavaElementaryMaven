package HomeWork19;

public class Produce extends Thread{

    private final Data data;

    public Produce(Data data) {
        this.data = data;
    }

    private synchronized int produce(){
        if (data.getCurrentData() == data.getMaxData()) {
            System.out.println("Data is overdrafted");
        }
        else {
            data.setCurrentData(data.getCurrentData()+1);
        }
        return data.getCurrentData();
    }

    public void run(){
        for (int i = 0; i < 30; i++) {
            System.out.println(currentThread().getName());
            System.out.println(produce());
            System.out.println("=====");
        }
    }
}
