class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public BankAccount openAccount(Customer customer, double initialBalance) {
        BankAccount account = new BankAccount(this, customer, initialBalance);
        customer.addAccount(account);
        customers.add(customer);
        System.out.println("Account opened for " + customer.getName() + " at " + name + " with balance " + initialBalance);
        return account;
    }
}

class Customer {
    private String name;
    private List<BankAccount> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void viewBalance() {
        for (BankAccount account : accounts) {
            System.out.println("Account at " + account.getBank().getName() + ": Balance = " + account.getBalance());
        }
    }

    public String getName() {
        return name;
    }
}

class BankAccount {
    private Bank bank;
    private Customer customer;
    private double balance;

    public BankAccount(Bank bank, Customer customer, double balance) {
        this.bank = bank;
        this.customer = customer;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ". New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn " + amount + ". New Balance: " + balance);
        }
    }

    public Bank getBank() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("ABC Bank");
        Customer customer1 = new Customer("John Doe");

        // Open account
        BankAccount account1 = bank.openAccount(customer1, 500);

        // Perform transactions
        account1.deposit(200);
        account1.withdraw(100);

        // View balance
        customer1.viewBalance();
    }
}
