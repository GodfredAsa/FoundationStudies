package com.company.FunctionalProgramming.Exercise;


import java.util.Comparator;
import java.util.List;


public class Courses {

    public static void main(String[] args) {





        courseContainingSpring(
                List.of(
                        "Spring", "Spring Boot", "API",
                        "Microservices", "AWS", "PCF",
                        "Azure", "Docker", "Kubernetes"));

        System.out.println("---------- courses with length greater then 4 -------------");
        courseWithLettersGreaterThan4(
                List.of(
                        "Spring", "Spring Boot", "API",
                        "Microservices", "AWS", "PCF",
                        "Azure", "Docker", "Kubernetes"));

        System.out.println("---------- courses and number of characters -------------");

        numberOfCharactersInCourse( List.of(
                "Spring", "Spring Boot", "API",
                "Microservices", "AWS", "PCF",
                "Azure", "Docker", "Kubernetes"));
    }


    public static void courseContainingSpring(List<String> courses){
        courses.stream()
                .filter(course->course.contains("Spring"))
                .forEach(Courses::printString);
    }

    public static void courseWithLettersGreaterThan4(List<String> courses){
        courses.stream()
                .filter(course->course.length()>=4)
                .sorted()
                .forEach(Courses::printString);
    }


//    sorts list of string based on length of each string
    public static void numberOfCharactersInCourse(List<String> courses){
        courses.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .map(course -> course + ": " + course.length())
                .forEach(System.out::println);

    }



    public static void printString(String course){
        System.out.println(course);
    }






}


