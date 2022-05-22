package com.company.SOLID_Principle.DependencyInversionPrinciple.Solution;
public class DebitCard implements BankCard {

    @Override
    public void doTransaction(long amount) {
        System.out.println("Debit Card Payment, amount GHC" + amount);
    }
}
