package com.company.SOLID_Principle.DependencyInversionPrinciple.Solution;

public class ShoppingMall {

    private BankCard bankCard;

    public ShoppingMall(BankCard bankCard) {
        this.bankCard = bankCard;
    }


    public void doPurchaseSomething(long amount){
        bankCard.doTransaction(amount);
    }


    public static void main(String[] args) {

//      shopping with card this makes the hides the type of card implementation
        BankCard creditCard = new CreditCard();
        ShoppingMall shoppingMall = new ShoppingMall(creditCard);
        shoppingMall.doPurchaseSomething(5000);




        BankCard debitCard = new DebitCard();
        ShoppingMall shoppingMall1 = new ShoppingMall(debitCard);

        shoppingMall1.doPurchaseSomething(7000);
    }


}
