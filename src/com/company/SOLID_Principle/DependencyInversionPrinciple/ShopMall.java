package com.company.SOLID_Principle.DependencyInversionPrinciple;

public class ShopMall {
    private Dcard dcard;
    private Ccard ccard;

//    Debit card constructor
    public ShopMall(Dcard dcard) {
        this.dcard = dcard;
    }

//    Credit card constructor
    public ShopMall(Ccard ccard) {
        this.ccard = ccard;
    }

    public void doPurchaseSomething(long amount){
        dcard.doTransaction(amount);
    }

    public static void main(String[] args) {
//        this process is violates the dependency inversion principle
//        as when there is something wrong with the card you need to make
//        a bunch of code changes at many places or lines.


//      making a purchase with a Debit card
        Dcard dcard = new Dcard();
        ShopMall shopMall = new ShopMall(dcard);
        shopMall.doPurchaseSomething(5000);

//      making a purchase with a Credit card
        Ccard ccard = new Ccard();
        ShopMall shopWithCreditCard = new ShopMall(ccard);
        shopWithCreditCard.doPurchaseSomething(1000);

    }


}
