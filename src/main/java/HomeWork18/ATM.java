package HomeWork18;

public class ATM {
    public static void main(String[] args) {

        Account account = new Account(111, 23, 11);

        Thread thread1 = new Thread(account);
        Thread thread2 = new Thread(account);

        thread1.setName("thread-1");
        thread2.setName("thread-2");

        thread1.start();
        thread2.start();

    }
}
