package com.company.Currying;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Letter {
    private String salutation;
    private String body;

    Letter(String salutation, String body){
        this.salutation = salutation;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "salutation='" + salutation + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public static void main(String[] args) {
        createLetter("letter", "hello there");

        BiFunction<String, String, Letter> SIMPLE_LETTER_CREATOR
                = Letter::new;

        System.out.println( "Bi function: " + SIMPLE_LETTER_CREATOR.apply("My letter", " my message"));

        Function<String, Function<String, Letter>> SIMPLE_CURRIED_LETTER_CREATOR
                = salutation -> body -> new Letter(salutation, body);

        Function<String, Function<Integer, Integer>> strToInteger = str1 -> str2 -> str1.length() + str2;

        System.out.println(strToInteger.apply("Hello").apply(1000));

        System.out.println( "currying: " + SIMPLE_CURRIED_LETTER_CREATOR
                .apply("Hello")
                .apply("This is my letter to the president"));
    }

    public static Letter createLetter(String salutation, String body) {
        System.out.println("salutation: " + salutation + ", Message: " + body);
        return new Letter(salutation, body);
    }
}

