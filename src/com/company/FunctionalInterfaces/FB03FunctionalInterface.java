package com.company.FunctionalInterfaces;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@SuppressWarnings("unused")
public class FB03FunctionalInterface {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);


        numbers.stream()
                .filter(isEvenPredicate())
                .map(squareFunction())
                .forEach(sysoutConsumer());

        
        Function<String, Integer> strToInteger = String::length ;
        System.out.println( "trimmed string: " + strToInteger.apply("hello   ".trim()));
        BiFunction<String, Integer, Integer> the  = (x,y) -> x.length() + y ;
        System.out.println( "The answer: " + the.apply("the world is mine", 10));


    }

    private static Consumer<Integer> sysoutConsumer() {
        return System.out::println;
    } //returns nothing

    private static Function<Integer, Integer> squareFunction() {
        return s -> s * s;
    } //returns something

    private static Predicate<Integer> isEvenPredicate() {
        return x -> x % 2 == 0;
    } // returns boolean



}
