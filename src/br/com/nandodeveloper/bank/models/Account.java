package br.com.nandodeveloper.bank.models;

public class Account extends User {
    private String email;
    private String pass;
    private int accountNumber;
    private double balance = 0;
    private int agency;

    public Account(String name, int age, String cpf, String gender, double initialBalance) {
        super(name, age, cpf, gender);
        this.balance = initialBalance;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public double getBalance() {
        return balance;
    }

    public int getAgency() {
        return agency;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void withdraw(double value) {
        if(value > balance) {
            System.out.println("Saldo insuficiente.\n");
        } else if (value == 0){
            System.out.println("Digite algum valor para sacar.\n");
        } else {
            balance -= value;
            System.out.println("Saque realizado com sucesso.");
            System.out.println("Saldo atual: " + balance);
            System.out.println();
        }
    }
    public void deposit(double value) {
        if(value > 0) {
            balance += value;
            System.out.println("Deposito realizado com sucesso.");
            System.out.println("Saldo atual: " + balance);
            System.out.println();
        } else {
            System.out.println("Digite um valor maior que 0.\n");
        }
    }

    public void menuConta(Account account) {
        String asterisco = "*********************************";
        System.out.println(asterisco + " Your Account " + asterisco);
        System.out.println("\nUsername: " + account.getName());
        System.out.println("Account number: " + account.getAccountNumber());
        System.out.println("Agency: " + account.getAgency());
        System.out.println("Balance: " + account.getBalance());
    }
}
