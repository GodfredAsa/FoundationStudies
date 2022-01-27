package com.company.FunctionalProgramming.Exercise;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class BehaviourParameterizationTrial {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);


        List<Integer> squared = createSquaredList(numbers, mapFunction());

        List<Integer> cubedNumbers = createSquaredList(numbers, number -> number * number * number);

        List<Integer> doubledNumbers = createSquaredList(numbers, x-> x * 2);

        System.out.println("numbers: " + numbers);
        System.out.println("doubled numbers: " + doubledNumbers);
        System.out.println("squared numbers: " + squared);
        System.out.println("cubed numbers: " + cubedNumbers);

// takes no input but returns an out mostly used in creating an object
        Supplier<String> getRandomNumberReturnString = () -> {
            Random random = new Random();
            int result = random.nextInt(100);
            if(result %2 ==0)
               return "random Number is even";
            else
               return "random Number is odd";
        };

        System.out.println(getRandomNumberReturnString.get());



    }

    private static List<Integer> createSquaredList(List<Integer> numbers, Function<Integer, Integer> mappingFunction )
    {
        return numbers.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }

    private static Function<Integer, Integer> mapFunction() {
        return x -> x * x;
    }





}
