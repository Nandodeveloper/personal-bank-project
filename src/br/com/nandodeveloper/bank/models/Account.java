package br.com.nandodeveloper.bank.models;

import br.com.nandodeveloper.bank.validation.MinorCheck;

public class Account extends User implements MinorCheck{
    private String accountNumber;
    private double balance = 0;
    private int agency;

    public Account(String name, int age, double initialBalance) {
        super(name, age);
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public int getAgency() {
        return agency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void withdraw(double value) {
        if(value > balance) {
            System.out.println("Insufficient balance.\n");
        } else if (value == 0){
            System.out.println("Enter an amount to withdraw.\n");
        } else {
            balance -= value;
            System.out.println("Withdrawal successful.");
            System.out.println("Current balance: " + balance);
            System.out.println();
        }
    }

    public void deposit(double value) {
        if(value > 0) {
            balance += value;
            System.out.println("Deposit successful.");
            System.out.println("Current balance: " + balance);
            System.out.println();
        } else {
            System.out.println("Enter a value greater than 0.\n");
        }
    }

    public void menuAccount(Account account) {
        String asterisk = "*********************************";
        System.out.println(asterisk + " Your Account " + asterisk);
        System.out.println("\nUsername: " + account.getName());
        System.out.println("Account number: " + account.getAccountNumber());
        System.out.println("Agency: " + account.getAgency());
        System.out.println("Balance: " + account.getBalance());
    }
    public void genAgency(Account account) {
        double genAgency = Math.random() * 10000;
        account.agency = (int) genAgency;
    }
    public void genAccountNumber(Account account) {
        double genA1 = Math.random() * 1000000;
        double genA2 = Math.random() * 10;
        int genA1Int = (int) genA1;
        int genA2Int = (int) genA2;
        String accountNumberS = genA1Int + "-" + genA2Int;
        account.accountNumber = accountNumberS;
    }

    @Override
    public void isMinor(Account account) {
        if (account.getAge() < 18) {
            System.out.println("You must be of legal age to register a bank account.");
            System.exit(0);
        }
    }
}