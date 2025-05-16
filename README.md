# 🏦 BankApp — Multithreaded Banking System in Java
## 📋 Overview
BankApp is a sample Java project that simulates concurrent money transfers between bank accounts using multithreading. It demonstrates how to handle financial operations safely in a multithreaded environment, while avoiding race conditions and deadlocks.

---

## ⚙️ Technologies Used
- Java SE
 - ExecutorService, Callable, Future
 - Thread-safe operations using synchronized
 - Deadlock prevention via consistent lock ordering
---

## 🧠 Core Components
### BankApp.java
The main class and entry point of the application.
It creates two accounts and performs two simultaneous transfers using a fixed thread pool and Future objects to retrieve results.

### TransferTask.java
A Callable<Boolean> implementation that handles transferring funds between two accounts.
It synchronizes access to both accounts and locks them in order of their IDs to prevent deadlocks.

### Account.java
A thread-safe model of a bank account.
Methods like deposit, withdraw, and getBalance are synchronized to ensure consistent behavior across threads.

---
## 💡 Highlights
✅ Thread-safe transfers between accounts

✅ Safe access via synchronized blocks

✅ Deadlock avoidance through ordered locking

✅ Asynchronous task execution with result tracking via Future

---
## 🧪 Sample Behavior
On execution, BankApp performs the following:

1. Creates two accounts, each with a starting balance of 1000.
2. Starts two parallel transfers:
- Transfer 100 from acc1 to acc2 
- Transfer 200 from acc2 to acc1 
3. Waits for both to complete and prints: 
- Success status of each transfer
- Final balances of both accounts
---
## 🛠 Potential Enhancements
- Improve error handling in withdraw

- Add transaction logging

- Implement transaction IDs and history tracking

- Create a GUI or REST API frontend