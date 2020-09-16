package HomeWork18;

public class Account extends Thread {

    private int balance;
    private int withdrawal;
    private int add;


    public Account(int balance, int withdrawal, int add) {
        this.balance = balance;
        this.withdrawal = withdrawal;
        this.add = add;
    }

    public void run() {
        for (int i = 0; i < 15; i++) {
            withdrawMoney(withdrawal);
            addMoney(add);
        }
    }

    public int getBalance() {
        return balance;
    }

    public synchronized void withdrawMoney(int withdrawal) {
        if (getBalance() >= withdrawal){
            System.out.println(Thread.currentThread().getName() + " withdraw " + withdrawal + " money");
            balance -= withdrawal;
            System.out.println("Now balance is " + getBalance() + "\n");
        }else System.out.println(
                                Thread.currentThread().getName() +
                                " tried to withdraw " + withdrawal + " money\n" +
                                "Not enough money =(" + "\n");
    }

    public synchronized void addMoney(int add){
        System.out.println(Thread.currentThread().getName() + " add " + add + " money");
        balance += add;
        System.out.println("Now balance is " + getBalance() + "\n");
    }

}