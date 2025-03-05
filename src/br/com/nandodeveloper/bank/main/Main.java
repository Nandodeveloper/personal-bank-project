package br.com.nandodeveloper.bank.main;

import br.com.nandodeveloper.bank.models.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> statement = new ArrayList<>();

        String asterisk = "*********************************";
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        Account account = new Account(name, age, 0);
        account.isMinor(account);

        System.out.println("Enter your CPF: ");
        String cpf  = scanner.next();
        account.setCpf(cpf);

        System.out.println("Enter your gender: ");
        String gender = scanner.next();
        account.setGender(gender);

        System.out.println("Registering...\n");

        account.genAgency(account);
        account.genAccountNumber(account);
        String actionsMenu = """
                
                1- User details
                2- Current account
                3- Deposit
                4- Withdraw
                5- Statement
                6- Exit""";

        System.out.println("Hello, " + name + ", welcome to the bank!\n");
        int action = 0;
        while (action != 6) {
            System.out.println(actionsMenu);
            action = scanner.nextInt();

            if (action == 1) {
                account.menuUser(account);
            } else if (action == 2) {
                account.menuAccount(account);
            } else if (action == 3) {
                System.out.println("Enter the amount you want to deposit: ");
                double deposit = scanner.nextDouble();
                account.deposit(deposit);
                statement.add("Deposit: " + deposit);
            } else if (action == 4) {
                System.out.println("Enter the amount you want to withdraw: ");
                double withdrawal = scanner.nextDouble();
                account.withdraw(withdrawal);
                if (withdrawal > account.getBalance()) {
                    statement.add("WITHDRAWAL DENIED: " + withdrawal);
                } else {
                    statement.add("Withdrawal: " + withdrawal);
                }
            } else if (action == 5) {
                System.out.println(statement);
            } else if (action == 6) {
                System.out.println("Ending...");
                break;
            } else {
                System.out.println("Enter a valid command.");
            }
        }
    }
}