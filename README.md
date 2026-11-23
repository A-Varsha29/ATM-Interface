# Task 3: ATM Interface

A console-based Java ATM simulation built for **Task 3** of a Java Programming Internship. The application models an Automated Teller Machine by separating account balance management (`BankAccount`) from ATM operations and menu interaction (`ATM`).

## Project Overview

This program provides an interactive command-line menu where a user can **withdraw money**, **deposit funds**, and **check their current balance**[cite: 5]. Every transaction validates user input and account limits before updating the balance, displaying clear success or failure messages after each action.

## Features

- **Bank Account Encapsulation (`BankAccount.java`):** Stores the user's account balance and controls balance changes safely.
- **ATM Operations (`ATM.java`):** Connects to the user's `BankAccount` and implements `withdraw(amount)`, `deposit(amount)`, and `checkBalance()`.
- **Menu-Driven Console Interface:** Runs a continuous loop with options for Withdraw, Deposit, Check Balance, and Exit.
- **Input & Balance Validation:** Prevents invalid text entries, rejects zero or negative amounts, and blocks withdrawals that exceed the available balance.
- **Transaction Feedback:** Prints clear confirmation or error messages with updated balance details after every operation.

## Code Structure

- `BankAccount.java`
  - `BankAccount(double initialBalance)`: Initializes the account with a non-negative starting balance.
  - `getBalance()`: Returns the current account balance.
  - `deposit(double amount)`: Adds valid positive funds to the balance.
  - `withdraw(double amount)`: Deducts funds only if the amount is positive and within the available balance.
- `ATM.java`
  - `withdraw(double amount)`: Validates withdrawal limits and prints success or failure messages.
  - `deposit(double amount)`: Validates deposit amounts and prints updated balance confirmation.
  - `checkBalance()`: Displays the current account balance.
  - `start()`, `displayMenu()`, `readMenuChoice()`, `readPositiveAmount(...)`: Handle menu navigation and console input validation.
  - `main(...)`: Creates a `BankAccount` (default starting balance: `1000.00`), connects it to `ATM`, and starts the session.

## Tech Stack & Tools

- **Language:** Java (JDK 25)
- **Standard Library:** `java.util.Scanner`
- **Editor & Version Control:** Visual Studio Code, GitHub

## How to Compile and Run

1. Open a terminal inside the project folder containing `BankAccount.java` and `ATM.java`.
2. Compile both source files:
   ```bash
   javac BankAccount.java ATM.java
