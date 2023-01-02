package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JustDoIt {
    public static void main(String[] args) {

        System.out.println(getFilteredNames());

    }

    private static List<String> getNames(){
        return Arrays.asList("ABC","ADZ", "AEC", "YBCA");
    }

    private static List<String> getFilteredNames(){
       return getNames().stream()
                .filter(name -> name.contains("A") && name.contains("Y"))
//                .filter(n -> n.contains("Y"))
                .collect(Collectors.toList());
    }
}
