
package org.example.bank;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BankApp {
    public static void main(String[] args) throws Exception {
        Account acc1 = new Account(1, 1000);
        Account acc2 = new Account(2, 1000);

        // Use ExecutorService to manage threads without having to manually create and start them.

        //  Create the ExecutorService:
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // Executors.newFixedThreadPool(2) : This creates a pool (a group) of exactly 2 threads.

        // Simulate 2 transfers happening at the same time
        TransferTask task1 = new TransferTask(acc1, acc2, 100);
        TransferTask task2 = new TransferTask(acc2, acc1, 200);

        /**
         * We’re transferring money both ways — so we want both tasks to run in parallel, using separate threads.
         * */

        //  Submit Tasks
        Future<Boolean> result1 = executor.submit(task1);
        Future<Boolean> result2 = executor.submit(task2);

        // Future: a promise to give you the result later. 'When the Thread (task) is completed.

        /**
         * Think of it like dropping off your laundry and getting a receipt.
         * The thread will tell you later whether the transfer succeeded.
         * */

        System.out.println("Transfer 1 successful: " + result1.get());
        System.out.println("Transfer 2 successful: " + result2.get());

        System.out.println("Final Balance of Account 1: " + acc1.getBalance());
        System.out.println("Final Balance of Account 2: " + acc2.getBalance());

        executor.shutdown();







    }
}
