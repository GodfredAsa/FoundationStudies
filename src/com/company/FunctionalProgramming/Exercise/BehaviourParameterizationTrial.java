package com.company.FunctionalProgramming.Exercise;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class BehaviourParameterizationTrial {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<Integer> squared = createSquaredList(numbers, mapFunction());
        List<Integer> doubledNumbers = createSquaredList(numbers, x-> x * 2);
        List<Integer> cubedNumbers = createSquaredList(numbers, number -> number * number * number);



        System.out.println("numbers: " + numbers);
        System.out.println("doubled numbers: " + doubledNumbers);
        System.out.println("squared numbers: " + squared);
        System.out.println("cubed numbers: " + cubedNumbers);

// takes no input but returns an out mostly used in creating an object
//        this function returns even or odd if the random number generated is even / odd
        Supplier<String> isEvenOrOddRandomGenerated = () -> {
            Random random = new Random();
            int result = random.nextInt(100);
            return result % 2 == 0  ? "even number: " + result : "odd number: " + result;
        };

        System.out.println(isEvenOrOddRandomGenerated.get());



    }

    private static List<Integer> createSquaredList(List<Integer> numbers, Function<Integer, Integer> mappingFunction )
    {
        return numbers.stream()
                .map(mappingFunction)
                .sorted(Comparator.comparingInt(Integer::intValue))
                .distinct()
                .collect(Collectors.toList());
    }

    private static Function<Integer, Integer> mapFunction() {
        return x -> x * x;
    }





}
