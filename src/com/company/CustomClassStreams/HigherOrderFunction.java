package com.company.CustomClassStreams;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class HigherOrderFunction {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4};


        System.out.println(specialFunction(arr, (a,b) -> a * b , 10));
        System.out.println(specialFunction(arr, Integer::sum, 1));




//        Functional Composition

        Predicate<String> startsWithA = (text) -> text.startsWith("A");
        Predicate<String> endsWithX = (text) -> text.endsWith("x");
        Predicate<String> composed = startsWithA.and(endsWithX);

        String statement = "A hardworking person must relax";
        System.out.println(composed.test(statement));

        Function<Integer, Integer> addTwo = (value) -> value + 2 ;
        Function<Integer, Integer> multiplyByTen = value -> value * 10;

        Function<Integer, Integer>  addTwoAndMultiplyByTen = addTwo
                                                                .andThen(multiplyByTen)
                                                                .andThen(addTwo);

        System.out.println(addTwoAndMultiplyByTen.apply(2));

        System.out.println("-----------------------------------------------------------");






        //        Using the HOF

        Predicate<Course> reviewScoreGreaterThan95 = createPredicateWithCutoffReviewScore(95);
        Predicate<Course> reviewScoreGreaterThan90 = createPredicateWithCutoffReviewScore(90);


        System.out.println(reviewScoreGreaterThan95.test(
                new Course("Spring", "Framework", 90, 20_000)));

        System.out.println(reviewScoreGreaterThan90.test(
                new Course("Spring", "Framework", 98, 20_000)));


        Function<Integer, Integer> factorial = HigherOrderFunction::getFactorial;
        
        System.out.println("Factorial Functional: " + factorial.apply(10));


// finds first course name with length greater than 11
    Optional<String> courseLengthGreaterThan11  = getCourses()
            .stream()
            .filter(course -> course.getName().length() > 11)
            .map(nameUpperCase -> nameUpperCase.getName().toUpperCase())
            .findFirst();

        System.out.println(courseLengthGreaterThan11);



        String str = "I can see the sun shines on my handsome and beautiful face";
        String[] newStr = str.split(" ");
        String generatedString = Arrays.stream(newStr)
                .map( word -> word.substring(0,1).toUpperCase() + word.substring(1))
                .collect(Collectors.joining(" "));

        System.out.println(generatedString);

        System.out.println("functional HOF: " + functionalHOF()
                .apply(new Course("Spring", "Framework", 90, 20_000)));

    }

    private static int specialFunction(int[] intArray, IntBinaryOperator func, int initialCounter){

        return Arrays.stream(intArray)
                .reduce(initialCounter, func);


    }

    private static int getFactorial(int i) {
        return i <= 1 ? 1: i * getFactorial(i -1);
    }

    private static Function<Course, Integer> functionalHOF(){
        return Course::getReviewScore;
    }

    //     Higher Order Function Demo : a function that returns another function
    private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
        return course -> course.getReviewScore() > cutoffReviewScore;
    }



    private  static List<Course> getCourses(){
        return  List.of(
                new Course("Spring", "Framework", 98, 20_000),
                new Course("Spring Boot", "Framework", 95, 18_000),
                new Course("API", "Microservices", 97, 19_000),
                new Course("Microservices", "Microservices", 96, 25_000),
                new Course("FullStack", "FullStack", 91, 21_000),
                new Course("Azure", "Cloud", 92, 2_000),
                new Course("AWS", "Cloud", 99, 26_000),
                new Course("Docker", "Cloud", 92, 25_000),
                new Course("Test Driven Development", "Test", 91, 18_000),
                new Course("Java", "Programming Language", 93, 19_000),
                new Course("Python", "Object Oriented", 98, 2_000),
                new Course("JavaScript", "Web Development", 94, 25_000)
        );
    }
}
