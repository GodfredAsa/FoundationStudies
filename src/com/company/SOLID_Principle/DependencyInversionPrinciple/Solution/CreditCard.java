package com.company.SOLID_Principle.DependencyInversionPrinciple.Solution;

// when a class implements an interface it means
// the card is a type of the interface implemented

// Credit card is a type of bank card
public class CreditCard implements BankCard {


    @Override
    public void doTransaction(long amount) {
        System.out.println("Payment using Credit Card");
    }
}
