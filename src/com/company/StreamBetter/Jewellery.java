package com.company.StreamBetter;

public class Jewellery {

    private String itemName;

    private int worth;

    public Jewellery(String itemName, int worth) {
        this.itemName = itemName;
        this.worth = worth;
    }

    public Jewellery() {
    }


    public String getItemName() {
        return itemName;
    }

    public  int getWorth() {
        return this.worth;
    }

    @Override
    public String toString() {
        return "Jewellery{" +
                "itemName='" + itemName + '\'' +
                ", worth=" + worth +
                '}';
    }


}
