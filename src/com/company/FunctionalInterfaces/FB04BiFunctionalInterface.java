package com.company.FunctionalInterfaces;



import java.util.function.*;

public class FB04BiFunctionalInterface {

    public static void main(String[] args) {


        BiPredicate<Integer, String> intValueGreaterThanStringLength = (intValue, str) ->
            intValue > str.length();
        System.out.println(intValueGreaterThanStringLength.test(20, "hello Word"));


        BiFunction<String, Integer, String> getNameAndAge = (name,age) ->
                name  + " is " + age + "years old";
        System.out.println(getNameAndAge.apply("John", 28));


        BiConsumer<String, String> printStrings = (str, str2) -> System.out.println(str.concat(str2));
        printStrings.accept("John and ", "Jane");


        IntBinaryOperator intBinaryOperator = Integer::sum;
        System.out.println( "Int Binary Operator: " + intBinaryOperator.applyAsInt(10, 20));


        IntFunction<Integer> get  = x -> x * x;

        System.out.println(get.apply(12));
    }







}
