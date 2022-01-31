package com.company.FunctionalInterfaces;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;


public class FB05MethodReferences {

    public static void main(String[] args) {

        List<String> courseList = new ArrayList<>(courses);




// * removes trailing white spaces
// * upper case first letter
// * sorts by length of word in descending order
// * outputs word with its length

        courseList.stream()
                .map(String::trim)
                .map(
                    firstLetterUpper ->
                        firstLetterUpper.substring(0,1).toUpperCase() +
                        firstLetterUpper.substring(1).toLowerCase())
                .sorted(Comparator.comparingInt(String::length).reversed())
                .map( word -> word + " : " + word.length())
                .forEach(System.out::println);


        courseList.removeIf(course -> course.length() < 6);

        System.out.println(courseList);
        //    constructor reference
        Supplier<String> constructorReference = String::new;

        System.out.println(constructorReference.get());

        System.out.println("--------- uppercase ----------");
        courses.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);

    }




    private static final List<String> courses = List.of(
            "spring", "spring Boot", "API",
            "Microservices", "AWS", "PCF",
            "Azure", "Docker", "Kubernetes");
}
