package com.company.SOLID_Principle.DependencyInversionPrinciple.Solution;


// Debit card  is a type of bank card
public class DebitCard implements BankCard {

    @Override
    public void doTransaction(long amount) {
        System.out.println("Payment with Debit Card");
    }
}
