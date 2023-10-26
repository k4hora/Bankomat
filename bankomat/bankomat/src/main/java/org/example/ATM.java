package org.example;
public interface ATM {
    void insertCard(int cardNumber);

    boolean enterPin(int pin);

    BankUser getCurrentUser();

    double checkBalance();

    Bank deposit(double amount);

    void withdraw(double amount);

    void ejectCard();

    void blockCard();

}
