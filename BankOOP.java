abstract class bankaccount {
    private String account_number;
    private String owner_name;
    private double balance;


    public bankaccount(String account_number, String owner_name, double balance) {
        this.account_number = account_number;
        this.owner_name = owner_name;
        this.balance = balance;
    }


    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("new balance after deposit: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public abstract void withdraw(double amount);

    public void getaccountinfo() {
        System.out.println("Account Number: " + account_number);
        System.out.println("Owner name: " + owner_name);
        System.out.println("Balance: " + balance);
    }


    public double getbalance() {
        return balance;
    }
}

// inheritance
class savingaccount extends bankaccount {
    public savingaccount(String account_number, String owner_name, double balance) {
        super(account_number, owner_name, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getbalance()) {
            double newbalance = getbalance() - amount;
            System.out.println("new balance after withdrawal: " + newbalance);
        } else {
            System.out.println("Invalid amount.");
        }
    }
}


class banksystem {
    public static void main(String[] args) {

        savingaccount account = new savingaccount("123456", "Punam Adhikari", 1000);

        account.deposit(500);
        account.withdraw(400);
        account.getaccountinfo();
    }
}