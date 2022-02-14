package com.company.Smooth;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Investor implements User{
    private String id;
    private String fullName;
    private int balance;



    public Investor(String fullName, int balance) {
        this.fullName = fullName;
        this.balance = balance;
    }

    public Investor(){}


    @Override
    public boolean makeDeposit(int amount) {
        return false;
    }

    @Override
    public boolean makeWithdrawal(int amount) {
        return false;
    }

    @Override
    public int checkBalance() {
        return 0;
    }


    public String getFullName() {
        return fullName;
    }

    public int getBalance() {
        return balance;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
