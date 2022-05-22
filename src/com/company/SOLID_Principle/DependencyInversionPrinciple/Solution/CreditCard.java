package com.company.SOLID_Principle.DependencyInversionPrinciple.Solution;

public class CreditCard implements BankCard {

    @Override
    public void doTransaction(long amount) {
        System.out.println("Credit Card Payment, amount GHC" + amount);
    }
}
