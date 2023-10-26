package org.example;

import java.util.Scanner;

public class Regition implements RegitionInterfase{
    long numberPhone;
    int userPassword;
    String name;
    int numberCard;
    public Regition(){

    }
    public Regition(long numberPhone, int userPassword, String name, int numberCard) {
        this.numberPhone = numberPhone;
        this.userPassword = userPassword;
        this.name = name;
        this.numberCard = numberCard;
    }

    BankATM bankATM = new BankATM();
    static Scanner cr = new Scanner(System.in);
    @Override
    public  void menu() {
        System.out.println("ПРИЛОЖЕНИЕ БАНКА");
        System.out.println("1-Зарегестрироваться ");
        System.out.println("2-Войти");
        int chose = cr.nextInt();
        if (chose == 1){
            registration();
        }else if (chose == 2){
            entrance();
        }
    }

    @Override
    public void password() {
        int password = cr.nextInt();
        this.userPassword = password;
    }

    @Override
    public void numberPhone() {
        long number = cr.nextLong();
        this.numberPhone = number;
    }

    @Override
    public void registration() {
        System.out.println("Введите ваше имя: ");
        String userName = cr.next();
        System.out.println("Введите номер телефона: ");
        numberPhone();
        System.out.println("Придумайте пароль: ");
        password();
        System.out.println("Добавте карту");
        System.out.println("Введите номер карты: ");
        int numberCard = cr.nextInt();
        System.out.println("Введите пин код: ");
        int pinCode = cr.nextInt();
        System.out.println("Введите cvv: ");
        int cvv = cr.nextInt();
        int id = (int) Math.random();
        bankATM.bankAccounts.add(new Bank(userName, id ,1, new BankCard(numberCard,pinCode,cvv) ,bankATM.regitions));
        System.out.println("Вы успешно создали аакаунт");
        System.out.println("А теперь войдите!");
        entrance();
    }

    @Override
    public void entrance() {
        System.out.println("Введите номер телефона: ");
        long number = cr.nextLong();
        System.out.println("Введите пароль: ");
        int password = cr.nextInt();
        if (number == numberPhone && password == userPassword ){
            System.out.println("Вы успешно вошли");
            bankATM.terminate();
        }else {
            System.out.println("Вы не правельно ввели данные");
        }
    }
}
