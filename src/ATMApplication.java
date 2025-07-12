import java.util.Scanner;

// Class to represent the Bank Account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }
}

// Class to represent the ATM Machine
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("\n===== Welcome to ATM Machine =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (1-4): ");
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    if (account.deposit(depositAmount)) {
                        System.out.println("Successfully deposited ₹" + depositAmount);
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Successfully withdrew ₹" + withdrawAmount);
                    } else {
                        System.out.println("Insufficient balance or invalid amount.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter between 1 and 4.");
            }
        }
    }
}

// Main class to run the ATM
public class ATMApplication {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance ₹1000
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}