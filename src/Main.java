import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> emails = new ArrayList<>();
        ArrayList<String> senhas = new ArrayList<>();
        ArrayList<String> extrato = new ArrayList<>();

        String asterisco = "*********************************";
        System.out.println("Digite seu nome: ");
        String name = scanner.nextLine();

        System.out.println("Digite sua idade: ");
        int age = scanner.nextInt();

        System.out.println("Digite o seu cpf: ");
        String cpf  = scanner.next();

        System.out.println("Digite seu gênero: ");
        String gender = scanner.next();

        System.out.println("Registrando...");



        System.out.println("Olá, " + name + ", seja bem vindo ao banco!\n");
        int acao = 0;
        while (acao != 6) {
            Account account = new Account(name, age, cpf, gender);

            String menuUser = asterisco + " User Details " + asterisco +
                    "\n\nUsername: " + account.getName() + " (Age: " + account.getAge() + ")" +
                    "\nCpf: " + account.getCpf() + "\nGender: " + account.getGender();

            String menuConta = asterisco + " Your Account " + asterisco +
                    "\n\nUsername: " + account.getName() +
                    "\nAccount number: " + account.getAccountNumber() +
                    "\nAgency: " + account.getAgency() +
                    "\nBalance: " + account.getBalance();

            String menuAcoes = "\n1- User details\n" + "2- Current account\n" +
                    "3- Depositar\n" + "4- Sacar\n" + "5- Extrato\n" + "6- Exit";

            System.out.println(menuAcoes);
            acao = scanner.nextInt();
            if (acao == 1) {
                System.out.println(menuUser);
            } else if (acao == 2) {
                System.out.println(menuConta);
            } else if (acao == 3) {
                System.out.println("Digite o valor que deseja depositar: ");
                double deposito = scanner.nextDouble();
                account.deposit(deposito);
                extrato.add("Deposito: " + deposito);
            } else if (acao == 4) {
                System.out.println("Digite o valor que deseja sacar: ");
                double saque = scanner.nextDouble();
                account.withdraw(saque);
                extrato.add("Saque: " + saque);
            } else if (acao == 5) {
                System.out.println(extrato);
            } else if (acao == 6) {
                System.out.println("Encerrando...");
                break;
            } else {
                System.out.println("Digite um comando válido.");
            }
        }
    }
}