// Abstract Base Class
abstract class BankAccount {
    private String accountNumber;  // Encapsulation (private)
    protected double balance;  // Protected for controlled access in subclasses

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public String getAccountInfo() {
        return "Account Number: " + accountNumber + ", Balance: " + balance;
    }

    protected void updateBalance(double amount) { // Protected method
        this.balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

// Using Inheritance
class SavingAccount extends BankAccount {
    private double interestRate; // Encapsulation (private)

    public SavingAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        updateBalance(amount); // Encapsulated method
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            updateBalance(-amount);
        } else {
            System.out.println("Insufficient Funds.");
        }
    }

    public double calculateInterest() {
        return getBalance() + (getBalance() * interestRate / 100); // Corrected Calculation
    }
}

// Another Child Class (Polymorphism)
class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        updateBalance(amount);
    }
    
    
    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance() + overdraftLimit) {
            updateBalance(-amount);
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }
}

// Demonstrating functionality
public class BankSystem {
    public static void main(String[] args) {
        SavingAccount savings = new SavingAccount("123456", 5000, 5);
        savings.deposit(1000);
        System.out.println(savings.getAccountInfo());
        System.out.println("Interest Earned: " + savings.calculateInterest());

        CheckingAccount checking = new CheckingAccount("654321", 3000, 1000);
        checking.withdraw(3500);
        System.out.println(checking.getAccountInfo());
    }
}