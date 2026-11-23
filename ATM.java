import java.util.Scanner;

public class ATM {
    private final BankAccount account;
    private final Scanner scanner;

    public ATM(BankAccount account, Scanner scanner) {
        this.account = account;
        this.scanner = scanner;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Transaction Failed: Withdrawal amount must be greater than 0.");
            return;
        }
        if (amount > account.getBalance()) {
            System.out.printf("Transaction Failed: Insufficient balance. Available balance: %.2f%n",
                    account.getBalance());
            return;
        }
        if (account.withdraw(amount)) {
            System.out.printf("Withdrawal Successful! Dispensed: %.2f | Remaining Balance: %.2f%n",
                    amount, account.getBalance());
        } else {
            System.out.println("Transaction Failed: Unable to process withdrawal.");
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Transaction Failed: Deposit amount must be greater than 0.");
            return;
        }
        if (account.deposit(amount)) {
            System.out.printf("Deposit Successful! Added: %.2f | Current Balance: %.2f%n",
                    amount, account.getBalance());
        } else {
            System.out.println("Transaction Failed: Unable to process deposit.");
        }
    }

    public void checkBalance() {
        System.out.printf("Current Account Balance: %.2f%n", account.getBalance());
    }

    public void start() {
        boolean running = true;

        System.out.println("=========================================");
        System.out.println("         WELCOME TO THE ATM MACHINE      ");
        System.out.println("=========================================");

        while (running) {
            displayMenu();
            int choice = readMenuChoice();

            switch (choice) {
                case 1:
                    double withdrawAmount = readPositiveAmount("Enter amount to withdraw: ");
                    withdraw(withdrawAmount);
                    break;
                case 2:
                    double depositAmount = readPositiveAmount("Enter amount to deposit: ");
                    deposit(depositAmount);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 4.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n--- ATM Menu ---");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choose an option (1-4): ");
    }

    private int readMenuChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Enter a number (1-4): ");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private double readPositiveAmount(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double amount = scanner.nextDouble();
                scanner.nextLine();
                if (amount > 0) {
                    return amount;
                }
                System.out.println("Please enter an amount greater than 0.");
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double initialBalance = 1000.00;
        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount, scanner);
        atm.start();
        scanner.close();
    }
}