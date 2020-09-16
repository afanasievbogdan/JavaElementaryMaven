package HomeWork19;

class Main{

    public static void main(String[] args) {

        Data data = new Data(5, 10, 0);

        Consume consume = new Consume(data);
        Produce produce = new Produce(data);

        Thread thread0 = new Thread(consume);
        Thread thread1 = new Thread(produce);

        thread0.setName("thread-consumer");
        thread1.setName("thread-producer");

        thread0.start();
        thread1.start();
    }
}
