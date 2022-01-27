package com.company.CustomClassStreams;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class HigherOrderFunction {
    public static void main(String[] args) {


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
    Optional<String> courseLengthGreaterThan11  = getCourses().stream()
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

    }

    private static int getFactorial(int i) {
        return i<= 1 ? 1: i * getFactorial(i -1);
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
