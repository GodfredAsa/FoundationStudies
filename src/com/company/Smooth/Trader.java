package com.company.Smooth;

public class Trader implements User{
    private int id;
    private String name;
    private int balance;

    public Trader(int id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Trader() {
    }

    @Override
    public boolean makeDeposit(int amount) {
        boolean status;
        if(amount < 1){
            status = false;
            System.out.println("Deposit not successful ");
        }else{
            System.out.println("deposit successful ");
            this.balance += amount;
            status = true;
            System.out.println("current balance GHC " + getBalance());
        }
        return status;
    }

    @Override
    public boolean makeWithdrawal(int amount) {
        return amount < getBalance();

    }

    @Override
    public int checkBalance() {
        System.out.println("Current Balance: " + getBalance());
        return getBalance();
    }

    public String getName() {
        return name;
    }

    private int getBalance() {
        return balance;
    }
}
