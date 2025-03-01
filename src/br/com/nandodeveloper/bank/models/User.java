package br.com.nandodeveloper.bank.models;

public class User {
    private String name;
    private String cpf = "";
    private int age;
    private String gender;

    public User(String name, int age, String cpf, String gender) {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void menuUser(User user){
        String asterisk = "*********************************";
        System.out.println(asterisk + " User Details " + asterisk);
        System.out.println("Username: " + user.getName() + " (Age: " + user.getAge() + ")");
        System.out.println("CPF: " + user.getCpf() + "\nGender: " + user.getGender());
    }
}