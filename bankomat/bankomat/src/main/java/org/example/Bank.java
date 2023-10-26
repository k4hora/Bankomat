package org.example;

import java.util.ArrayList;

public class Bank implements BankUser {
    private String userName;
    private int accountId;
    private double accountBalance;
    private BankCard userCard;
    private ArrayList<Bank> numberPhone;

   public Bank(){

   }
    public Bank(String userName, int accountId, double accountBalance, BankCard userCard, ArrayList<Bank> numberPhone) {
        this.userName = userName;
        this.accountId = accountId;
        this.accountBalance = accountBalance;
        this.userCard = userCard;
        this.numberPhone = numberPhone;

    }


    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public int getAccountId() {
        return accountId;
    }

    @Override
    public double getAccountBalance() {
        return accountBalance;
    }
    @Override
    public BankCard getUserCard() {
        return userCard;
    }

    @Override
    public Regition getNumberPhone() {
        return null;
    }

    @Override
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}



