package com.company;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Comparator<String> comparator = String::compareTo;


        Comparator<String> comparatorReversed = comparator.reversed();


        List<String> list = new java.util.ArrayList<>(List.of("one", "two", "three"));

        list.sort(comparatorReversed);

        System.out.println(list);


    }
}
