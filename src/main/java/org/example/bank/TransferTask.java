package org.example.bank;

import java.util.concurrent.Callable;

/**
 * Task to transfer funds between two accounts.
 */
public class TransferTask  implements Callable<Boolean> {

    // Fields:
    private final Account fromAccount; // The account to take money from.
    private final Account toAccount;   // The account to send money to.
    private final double amount;      // How much money to transfer.

    // This builds a new transfer task. It stores the two accounts and the transfer amount.
    public TransferTask(Account fromAccount, Account toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public Boolean call() {
        // To prevent deadlock, always lock accounts in order of their IDs

        /**
         * fromAccount -> ID = 2   ,  toAccount -> ID = 5
         * Then :
         * firstLock : fromAccount
         * secondLock : toAccount
         *
         * So both threads, no matter which accounts they're transferring between, will always lock in the same order
         * */
        Account firstLock = fromAccount.getId() <  toAccount.getId() ? fromAccount : toAccount;
        Account secondLock = fromAccount.getId() < toAccount.getId() ? toAccount : fromAccount;

        synchronized (firstLock){
            synchronized (secondLock){
                // Critical section goes here
                if(fromAccount.withdraw(amount)){
                    toAccount.deposit(amount);
                    return true;
                }else {
                    return false;
                }
            }
        }

    }
}