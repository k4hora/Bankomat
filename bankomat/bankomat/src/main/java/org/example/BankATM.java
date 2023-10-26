package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class BankATM implements ATM {
    static Scanner sc = new Scanner(System.in);
    private BankCard currentCard;
    private Bank currentUser;
    private int remainingPinAttempts;
    private boolean next = false;
    public ArrayList<Bank> regitions = new ArrayList<Bank>();
    public ArrayList<BankCard> cards = new ArrayList<BankCard>();
    public ArrayList<Bank> bankAccounts = new ArrayList<>();
    public BankCard CardOne = new BankCard(123456,1234,123);
    public BankCard CardTwo = new BankCard(654321,4321,321);
    public BankCard CardThree = new BankCard(74343,5351,619);
    public BankCard CardFore = new BankCard(87643,1456,042);
    public BankCard CardFife = new BankCard(35566,9732,654);
    public Bank bankAccountsOne = new Bank("Stepan",1,1234, CardOne, regitions );
    public Bank bankAccountsTwo = new Bank("Slayik",2,4321, CardTwo, regitions);
    public Bank bankAccountsThree = new Bank("Borise",3,543, CardThree, regitions);
    public Bank bankAccountsFore = new Bank("Andrey",4,1652,CardFore, regitions);
    public Bank bankAccountsFife = new Bank("Saha",5,12654,CardFife, regitions);

    private int checkMethod() {
        System.out.println("Что бы посмотреть баланс введите 1");
        System.out.println("Что бы положить деньги введите 2");
        System.out.println("Что бы снять деньги введите 3");
        System.out.println("Что бы выйти с терминала введите 4");
        int method = sc.nextInt();
        return method;
    }
    private int checkPinCode() {
        System.out.println("Введите пин-код:");
        int pinCode = sc.nextInt();
        return pinCode;
    }
    private double checkMethodsTwo() {
        System.out.println("Введите сумму которую хотите положить:");
        double sum = sc.nextDouble();
        return sum;
    }
    private double checkMethodsThree() {
        System.out.println("Введите сумму которую хотите снять:");
        double sum = sc.nextDouble();
        return sum;
    }
    public void terminate() {
        cards.add(CardOne);
        cards.add(CardTwo);
        cards.add(CardThree);
        cards.add(CardFore);
        cards.add(CardFife);
        bankAccounts.add(bankAccountsOne);
        bankAccounts.add(bankAccountsTwo);
        bankAccounts.add(bankAccountsThree);
        bankAccounts.add(bankAccountsFore);
        bankAccounts.add(bankAccountsFife);

                    int method = checkMethod();
                    if(method == -1){
                        System.out.println("Вы ввели не правильный тип данных");
                        method = checkMethod();
                    }
                    if (method == 1) {
                        System.out.println(checkBalance());
                        method = checkMethod();
                    } else if (method == 2) {
                        double sum = checkMethodsTwo();
                        if(sum == -1){
                            System.out.println("Вы ввели не правильный тип данных");
                            sum = checkMethodsTwo();
                        }else {
                            deposit(sum);
                        }
                        method = checkMethod();
                    } else if (method == 3) {
                        double sum = checkMethodsThree();
                        if(sum == -1){
                            System.out.println("Вы ввели не правильный тип данных");
                            sum = checkMethodsThree();
                        }else {
                            withdraw(sum);
                        }
                        method = checkMethod();
                    } else if (method == 4) {
                        System.out.println("Вы вышли из терминала");
                        ejectCard();
                    }

                return;


    }
    @Override
    public void insertCard(int cardNumber) {
        for(int i = 0; i < cards.size(); i++) {
            if(cards.get(i).getCardNumber() == cardNumber){
                currentCard = cards.get(i);
            };
        }
        remainingPinAttempts = 3;
    }

    @Override
    public boolean enterPin(int pin) {
        if (currentCard != null && pin == currentCard.getPinCode() && remainingPinAttempts > 0) {
            for(int i =0; i < bankAccounts.size(); i++) {
                if (bankAccounts.get(i).getUserCard() == currentCard){
                    currentUser = bankAccounts.get(i);
                    System.out.println("Вы успешно вошли");
                    getCurrentUser();
                }
            }
            return true;
        } else {
            remainingPinAttempts--;
            if (remainingPinAttempts == 0) {
                blockCard();
            }
            return false;
        }
    }

    @Override
    public BankUser getCurrentUser() {
        System.out.println("Имя: " + currentUser.getUserName());
        return currentUser;
    }

    @Override
    public double checkBalance() {
        if (currentUser != null) {
            return currentUser.getAccountBalance();
        }
        return 0.0;
    }

    @Override
    public Bank deposit (double amount){
        Bank bank = new Bank();
        bank.getUserCard();
        double x = currentUser.getAccountBalance();
        if (amount > 0) {
            currentUser.setAccountBalance(x += amount);
            System.out.println("Успешно положили " + amount + "У вас на счету стало: " + x);
        } else {
            System.out.println("Вы ввели не допустимую сумму");
        }

        return null;
    }
    @Override
    public void withdraw(double amount) {
        double x = currentUser.getAccountBalance();
        if (amount > 0 && amount <= x) {

            currentUser.setAccountBalance(x -= amount);
            System.out.println("Успешно сняли " + amount + "У вас на счету стало: " + x);
        }else {
            System.out.println("Вы ввели не допустимую сумму");
        }
    }

    @Override
    public void ejectCard() {
        currentCard = null;
        currentUser = null;
    }

    @Override
    public void blockCard() {
        System.out.println("Вы заблакированны");
        currentCard.setIsBlocked(true);
    }
}


