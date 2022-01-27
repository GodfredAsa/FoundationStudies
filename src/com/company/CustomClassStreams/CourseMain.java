package com.company.CustomClassStreams;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;



public class CourseMain {
    public static void main(String[] args) {


        System.out.println( "factorial of 5: " + getFactorial(5));

        System.out.println( "factorial for each : " + getFactorialForEach(List.of(1,2,3,4,5,6,7)));


        List<String> courses1 = List.of("Spring","Spring Boot", "AWS", "AZURE", "PCF", "DOCKER");
        List<String> courses2 = List.of("Spring","Spring Boot", "AWS", "AZURE", "PCF", "DOCKER");

        System.out.println(
                courses1.stream()
                        .flatMap( course -> courses2.stream().map( course2 -> List.of(course, course2)))
                        .filter( list -> !list.get(0).equals(list.get(1)))
                        .collect(Collectors.toList())
        );


//      FILTERING BASED ON LENGTH
        System.out.println(
                courses1.stream()
                        .flatMap( course -> courses2
                                .stream()
                                .filter( course2 -> course2.length() == course.length()  )
                                .map( course2 -> List.of(course, course2)))
                        .filter(list -> !list.get(0).equals(list.get(1)))
                        .collect(Collectors.toList())
        );




        System.out.println( "all courses have review score > 96: " +
                getCourses().stream().allMatch(doAllCoursesHaveAReviewGreaterThan96Predicate()));


        System.out.println( "is there a course whose review score is > 98: " +
                getCourses()
                        .stream()
                        .anyMatch(AllCoursesHaveAReviewScoreGreaterThan80Predicate()));


        System.out.println("\n----- Best Three Courses Based on Review Score -------");
         getBestThreeCoursesByReviewScore(getCourses());

        System.out.println("\n -------   course with reviews greater than 95  --------- \n ");
        getCourseWithReviewScoreGreaterThan95(getCourses());

        System.out.println("\n");
        takeAllTillReviewScoreLessThan95(getCourses());

        System.out.println("\n");
        dropWhileReviewScoreGreaterEqual95(getCourses());

        System.out.println("\n");
        System.out.println("------------- Best Course  ----------------");
        System.out.println(findBestCourseComparingReviewsAndNumberOfStudents(getCourses()));

        System.out.println("\n");

        System.out.println("------------- Worst Course  ----------------");
        System.out.println(findLeastCourseComparingReviewsAndNumberOfStudents(getCourses()));

        System.out.println("\n");
        System.out.println("------------- Worst Course II ----------------");
        System.out.println(minCourseByReviewsAndNoOfStudents(getCourses()));

        System.out.println("\n");
        System.out.println("------------- first course with review score less than 95 ----------------");
        System.out.println(findFirstCourseWithReviewScoreLessThan95(getCourses()));

        System.out.println("\n");
        System.out.println("------------- total number of students  with review score less than 95 ----------------");
        System.out.println(getTotalStudentsWithReviewScoreLessThan95(getCourses()));


        System.out.println("Maximum Number of Students With Review < 95: " + getMaxNoOfStudentsWithReviewScoreLessThan95(getCourses()));

        System.out.println("Average Number of Students With Review < 95: " + getAverageOfStudentsWithReviewScoreLessThan95(getCourses()));



        Map<String, List<Course>> coursesGroupedByCategory = groupCoursesByCategory(getCourses());
        for (Map.Entry<String, List<Course>> entry : coursesGroupedByCategory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        System.out.println(countCoursesByCategory(getCourses()));


        System.out.println("---------------  -------------------");
        System.out.println(getCourseWithMaxReviewBasedByCategory(getCourses()));


        System.out.println("-------------  something new just done today -------------------");
        System.out.println(groupCoursesByCategoryAndMapByNameToList(getCourses()));



    }


    private static  int getFactorial(int n){
        return  n <= 1 ? 1: n * getFactorial(n-1);
    }



    private static List<Integer> getFactorialForEach(List<Integer> numbers){
       return numbers.stream()
               .map(CourseMain::getFactorial)
               .collect(Collectors.toList());
    }



    private static Map<String, List<String>> groupCoursesByCategoryAndMapByNameToList(List<Course> courses){
        return courses.stream()
               .collect(
                       Collectors.groupingBy(Course::getCategory,
                       Collectors.mapping(Course::getName, Collectors.toList()))
               );
    }





    private static Map<String, List<Course>> groupCoursesByCategory(List<Course> courses){
        return courses
                .stream()
                .collect(Collectors.groupingBy(Course::getCategory));
    }



    private static Map<String, Long> countCoursesByCategory(List<Course> courses){
        return courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()));
    }



    private static Map<String, Optional<Course>> getCourseWithMaxReviewBasedByCategory(List<Course> courses){
        return courses.stream()
                .collect
                        (
                            Collectors.groupingBy(Course::getCategory ,
                            Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))
                        );
    }



    private static int getTotalStudentsWithReviewScoreLessThan95(List<Course> courses){
        return courses.stream()
                .filter(getCoursesWithReviewsLessThan95())
                .mapToInt(Course::getNoOfStudents)
                .sum();
    }



    private static OptionalDouble getAverageOfStudentsWithReviewScoreLessThan95(List<Course> courses){
        return courses.stream()
                .filter(getCoursesWithReviewsLessThan95())
                .mapToInt(Course::getNoOfStudents)
                .average();
    }



    private static OptionalInt getMaxNoOfStudentsWithReviewScoreLessThan95(List<Course> courses){
        return courses.stream()
                .filter(getCoursesWithReviewsLessThan95())
                .mapToInt(Course::getNoOfStudents)
                .max();
//        you can also do the min to get the minimum number of students with the same condition
    }


    private static Optional<Course> findFirstCourseWithReviewScoreLessThan95(List<Course> courses){
        return courses.stream()
                .filter(getCoursesWithReviewsLessThan95())
                .findFirst();
    }



// filters course with reviews < 95
// compares reviews and number of students
// get min course else return a new course without values
    private static  Course minCourseByReviewsAndNoOfStudents(List<Course> courses){
       return courses.stream()
                .filter(getCoursesWithReviewsLessThan95())
                .min(comparesReviewScoreAndNoOfStudents())
                .orElse(new Course());
    }



    private static Predicate<Course> getCoursesWithReviewsLessThan95() {
        return course-> course.getReviewScore() < 95;
    }



    private static Optional<Course> findBestCourseComparingReviewsAndNumberOfStudents(List<Course> courses){
        return courses.stream()
                .max(comparesReviewScoreAndNoOfStudents());
    }



    private static Optional<Course> findLeastCourseComparingReviewsAndNumberOfStudents(List<Course> courses){
        return courses.stream()
                .min(comparesReviewScoreAndNoOfStudents());
    }



    private static Comparator<Course> comparesReviewScoreAndNoOfStudents() {
        return Comparator.comparingInt(Course::getReviewScore)
        .thenComparingInt(Course::getNoOfStudents);
    }



    private static Predicate<Course> doAllCoursesHaveAReviewGreaterThan96Predicate() {
        return reviewScore-> reviewScore.getReviewScore()>96;
    }



    private static Predicate<Course> AllCoursesHaveAReviewScoreGreaterThan80Predicate() {
        return reviewScore-> reviewScore.getReviewScore()>98;
    }



    private static void takeAllTillReviewScoreLessThan95(List<Course> courses){
        courses.stream()
                .takeWhile(course-> course.getReviewScore() >= 95)
                .forEach(System.out::println);
    }



    private static void dropWhileReviewScoreGreaterEqual95(List<Course> courses){
        courses.stream()
                .dropWhile(course-> course.getReviewScore() >= 95)
                .forEach(System.out::println);
    }



    private static  void getBestThreeCoursesByReviewScore(List<Course> course){
         course.stream()
                .sorted(compareByReviewScoreCategoryAndNoOfStudent())
                 .limit(3)
                .forEach(System.out::println);
    }



    private static void getCourseWithReviewScoreGreaterThan95(List<Course> courses){
        courses.stream()
                .filter(review-> review.getReviewScore() > 95)
                .sorted(Comparator.comparingInt(Course::getReviewScore).reversed())
                .forEach(System.out::println);
    }



    private static Comparator<Course> compareByReviewScoreCategoryAndNoOfStudent() {
        return Comparator
                .comparingInt(Course::getReviewScore)
                .thenComparing(Course::getCategory)
                .thenComparingInt(Course::getNoOfStudents)
                .reversed();
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
