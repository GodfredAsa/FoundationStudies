package com.company.FunctionalInterfaces;


import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class FB05MethodReferences {

    public static void main(String[] args) {

// * removes trailing white spaces
// * upper case first letter
// * sorts by length of word in descending order
// * outputs word with its length

        courses.stream()
                .map(String::trim)
                .map(firstLetterUpper -> firstLetterUpper.substring(0,1).toUpperCase() + firstLetterUpper.substring(1).toLowerCase())
                .sorted(Comparator.comparingInt(String::length).reversed())
                .map(word-> word + " : " + word.length())
                .forEach(System.out::println);

        //    constructor reference
        Supplier<String> constructorReference = String::new;

        System.out.println(constructorReference.get());

    }










    private static final List<String> courses = List.of(
            "spring  ", "spring Boot", "API",
            "Microservices", "AWS", "PCF",
            "Azure", "Docker", "Kubernetes");
}
