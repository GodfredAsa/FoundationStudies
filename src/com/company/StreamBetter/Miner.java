package com.company.StreamBetter;

import java.util.List;

public class Miner {
    private String name;
    private String place;
    private List<Jewellery> jewelleries;


    public Miner(String name, String place, List<Jewellery> jewelleries) {
        this.name = name;
        this.place = place;
        this.jewelleries = jewelleries;
    }

    public Miner() {
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public List<Jewellery> getJewelleries() {
        return jewelleries;
    }

    @Override
    public String toString() {
        return "Miner{" +
                "name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", jewelleries=" + jewelleries +
                '}';
    }
}
