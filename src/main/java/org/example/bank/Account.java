package org.example.bank;

/**
 * Represents a bank account with thread-safe operations.
 * StringBuffer
 *
 */
public class Account {
    private final int id;
    private double balance;

    public Account(int id, double initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public int getId() {
        return id;
    }

    /**
     * The synchronised keyword ensured that we have synchronised value
     * The rading thread sees the most up-to-date value of balance
     * @return
     */
    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void setBalance(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public synchronized boolean withdraw(double amount){
        if (amount < balance) {
            System.out.println("You don't have have " + amount + "in your balance");
            System.out.println("Your balance is " + getBalance());
            return false;
        }
        balance -= amount;


    }
}
