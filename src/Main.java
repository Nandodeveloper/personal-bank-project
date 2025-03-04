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

        System.out.println("Enter your CPF: ");
        String cpf  = scanner.next();

        System.out.println("Enter your gender: ");
        String gender = scanner.next();

        Account account = new Account(name, age, cpf, gender, 0);
        System.out.println("Registering...\n");
        account.isMinor(account);

        account.genAgency(account);
        account.genAccountNumber(account);
        String actionsMenu = "\n1- User details\n" + "2- Current account\n" +
                "3- Deposit\n" + "4- Withdraw\n" + "5- Statement\n" + "6- Exit";

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
                statement.add("Withdrawal: " + withdrawal);
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