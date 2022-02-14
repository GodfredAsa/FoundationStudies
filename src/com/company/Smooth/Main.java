package com.company.Smooth;

public class Main {
    public static void main(String[] args) {
        User trader = new Trader(1, "Fred", 100);


        trader.makeDeposit(12);
//        trader.makeDeposit(0);

        trader.checkBalance();


        User investor = new Investor("Godfried Asumadu", 20);


        investor.checkBalance();
    }
}
