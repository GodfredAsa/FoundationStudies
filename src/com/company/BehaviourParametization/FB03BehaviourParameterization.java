package com.company.BehaviourParametization;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

// this work space demonstrate behavior parameterization
public class FB03BehaviourParameterization {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12,9,13,4,6,2,4,12,15, 10);
        System.out.println(transformer("Pig latin is cool"));
        System.out.println(transformer("Hello world !"));

        System.out.println("Get Factorial of a number: " + getFactorial(6));
        System.out.println("my Best" + myBet(numbers, (x) -> x , y -> y > 12 ));

        List<String> stringList = Arrays.asList("Hello", "Hi", "Hey");
        mapAndCreateNewGenerics(stringList, (t) -> String.valueOf(t.length()));
        System.out.println("Generic lists: " + mapAndCreateNewGenerics(stringList, (t) -> String.valueOf(t.length())));

        System.out.println(newTeller(numbers, (number) -> 2 * number));

        filterAndPrint(numbers, x -> x % 3 == 0);
        System.out.println("--------------------");
        filterAndPrint(numbers, x -> x % 4 == 0);

        System.out.println("real numbers: " + numbers);

        List<Integer> doubledNumbers = mapAndCreateNewList(numbers, x-> x*2);
        System.out.println("double numbers: " + doubledNumbers);

        List<Integer> squaredNumbers = mapAndCreateNewList(numbers, (x) -> x * x);
        System.out.print( "squared numbers: " + squaredNumbers);

        List<Integer> cubesOfNumbers = mapAndCreateNewList(numbers, x-> x*x*x);
        System.out.println( "cubed numbers: " + cubesOfNumbers);

        List<String> str = List.of("Hello", "Banana", "Sugar", "Horse");
        List<Integer> stringToIntegerList = mapStrToIntegerList(str);
        System.out.println( "lists of strings to numbers: " + stringToIntegerList);


// supplier takes no input but returns a value ** this function prints even if the random value is even or odd if so.
        Supplier<String> returnEvenOrOdd = () -> {
                        Random random  =  new Random();
                        int result = random.nextInt(100);
                        return result % 2 == 0 ? "even number"  :  "odd number";
        };
        System.out.println( "supplier method = " + returnEvenOrOdd.get());
        System.out.println( "test is running: " + createListTest(numbers, t-> t * 10));
    }

    private static List<Integer> createListTest(List<Integer> testNumbers, Function<Integer, Integer> testFunc){
        return testNumbers
                .stream()
                .map(testFunc)
                .collect(Collectors.toList());
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
        return numbers.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }

    private static <T> List<T> mapAndCreateNewGenerics(List<T> t, Function<T, T> mappingFunction) {
        return t.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }

    private static final Function<String, Integer> strToInteger = String::length;
    private static   List<Integer> mapStrToIntegerList(List<String> str){
       return str.stream()
                .map(FB03BehaviourParameterization.strToInteger)
                .collect(Collectors.toList());
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> integerPredicate) {
        numbers.stream()
                .filter(integerPredicate)
                .forEach(System.out::println);
    }

    public static List<Integer> newTeller(List<Integer> numbers, Function<Integer, Integer> myFunc){
      return   numbers.stream()
              .filter( number ->  number% 2 == 0 )
              .map(myFunc)
              .collect(Collectors.toList());
    }

    public static List<Integer> myBet(List<Integer> listsOfNumbers, Function<Integer, Integer> function, Predicate<Integer> predicate){
        return listsOfNumbers // list of numbers
                .stream()
                .filter(predicate) // predicate here
                .map(function) // function here
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

//    Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
//    Eg: pigIt('Pig latin is cool'); =>  igPay atinlay siay oolcay
//    pigIt('Hello world !');     // elloHay orldway !

    private static String transformer(String str){
        return  Arrays.stream(str.split(" "))
                .map(word-> word.substring(1) + word.charAt(0) + "ay")
                .map(w-> w.replaceAll("\\p{Punct}",""))
                .collect(Collectors.joining(" "));
    }

    public static int getFactorial(int number){
        return number <= 1 ? 1: number * getFactorial(number -1 );
    }




}
