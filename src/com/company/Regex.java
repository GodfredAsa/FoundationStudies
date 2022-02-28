package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Regex {

    public static void main(String[] args) {

        String phoneNumber2 = "0244123123";
        System.out.println( "new phone number: " + phoneNumber2.replaceAll("[^123]", "abc"));

        getValidEmails(getEmails());

        System.out.println("-----------------------------------------------");

        /**
        String mainString = "123456789";
        char[] charString = mainString.toCharArray();
        StringBuilder sbf = new StringBuilder();
        int counter = charString.length ;
        System.out.println(counter);
        for (int i = 0; i < charString.length ; i++) {
           counter--;
           sbf.append(charString[counter]);
        }
        System.out.println(sbf.toString());

         */




        System.out.println("white spaces with underscore".replaceAll("\\s", "_"));
// 3 letters followed dot followed 3 numbers eg abc.134
        System.out.println("abcd.135 " + "abc.135".matches("^[a-z]{3}+[\\.][0-9]{3}+$"));

        System.out.println("regular expression: " + "(123) 456-7890".matches("^([\\(][0-9]{3}[\\)][ ][0-9]{3}[\\-][0-9]{4})"));

        System.out.println("054 867 0632".matches("^(0[1-9]{2}[ ][0-9]{3}[ ][0-9]{4})"));
        System.out.println("054 470 4424".matches("^(0[1-9]{2}[ ][0-9]{3}[ ][0-9]{4})"));
        System.out.println("fred@epals.com => " + "fred@epals.com".matches("^([a-z]{2,30}[\\@][a-z]{2,30}[\\.][a-z]{2,5})"));
        System.out.println("godfred_epals.com => " + "godfred_epals.com".matches("^([a-z]{2,30}[\\@][a-z]{2,30}[\\.][a-z]{2,5})"));

        String turntablEmail = "godfred.asamoah@turntabl.io";
//
        System.out.println(turntablEmail + ": " + turntablEmail.matches("^([a-z]{2,15}[\\.][a-z]{2,15}[\\@]turntabl.io)$"));

        System.out.println("golden.heroe1@gmail.com" + ": " + "golden.heroe1@gmail.com".matches("^([a-z]{2,15}[\\.][a-z]{2,15}[\\@]turntabl.io)$"));
//
        String phoneNumber = "0548670632";
        String alteredPhoneNumber = phoneNumber.replaceAll("[^632]", "#"); // changes everything except 6, 3, and 2
        System.out.println(alteredPhoneNumber);

        System.out.println(phoneNumber.replaceAll("^054", "027")); // changes 054 to 027

        String string = "abcdefghijklmnop12345678";

        System.out.println(string.replaceAll("(?i)[a-f3-8]", "X"));

        System.out.println("Replace all numbers in a string: " + string.replaceAll("[0-9]", "#"));
        System.out.println("Replace all letters in a string: " + string.replaceAll("(?i)[a-z]", "#"));
        System.out.println("Replace all letters in a string: " + string.replaceAll("[A-Za-z]", "#"));
//
//
        System.out.println(repplaceLettersWithX("I have 3 beautiful apples with mine 7 girlFriends"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-Heading</h2>");
        htmlText.append("<p>This is a paragraph about something </p>");
        htmlText.append("<p>This is another paragraph about something else</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary</p>");

        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());


        int count = 0;
        matcher.reset();

        while (matcher.find()) {
            count++;
            System.out.println("occurence " + count + " start: " + matcher.start() + " ends " + matcher.end());
        }


        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());

        groupMatcher.reset();

        while (groupMatcher.find()) {

            System.out.println("occurence " + groupMatcher.group());
        }


//        picks the content of h2 tags
        String h2Text = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2Text);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while (h2TextMatcher.find()) {
            ;
            System.out.println(h2TextMatcher.group(2));
        }


        String tvTest = "tstvtkt";

        String tNotVRegex = "t(?!v)"; // whether there is a letter after the last t or not still considers it
        //String tNotVRegex = "t[^v]"; // only considers if there is a letter after the  last t letter

        Pattern tNotVPattern = Pattern.compile(tNotVRegex);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);
        while (tNotVMatcher.find()) {
            System.out.println(tNotVMatcher.group());
            System.out.println("Occurrence: " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }


        String exctractNumberPairs = "{0,2},{0,5},{1,3},{2,4},{x,y},{12,41}";
        Pattern patternNumberPairs = Pattern.compile("\\{(\\d+,\\d+)\\}");
        Matcher matcherNumberPairs = patternNumberPairs.matcher(exctractNumberPairs);
        while (matcherNumberPairs.find()) {
            System.out.println("Number pair occurrence: " + matcherNumberPairs.group(1));
        }
    }


    private static List<String> getEmails() {
        return Arrays.asList(
                "fred.asamoah@turntabl.io",
                "ivon.thehulk@gmail.com",
                "elisa_few@turntabl.io",
                "hebrew.james@turntabl.io",
                "johnson.johnson@gmai.com");
    }

    private static void getValidEmails(List<String> emails) {
        emails.stream()
                .filter( email -> email.matches("[a-z]{2,15}\\.[a-z]{2,30}[\\@]turntabl.io$") ||
                                 email.matches("[a-z]{2,15}\\.[a-z]{2,30}[\\@]gmail.com$") )
                .sorted()
                .forEach(System.out::println);
    }

    private static String repplaceLettersWithX(String str) {

        return Arrays.stream(str.trim().split(" "))
                .map(letter -> letter.replaceAll("(?i)[a-z]", "X"))
//              .map(numbers -> numbers.replaceAll("\\d", "#")) // replace numbers with #
                .collect(Collectors.joining(" "));

    }

//
//    private static String barGraph(int n) {
//        StringBuilder sbf = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                sbf.append("#".repeat(n - j));
//            }
//            sbf.append("\n");
//        }
//
//        return sbf.toString();
//
//
//    }
//
//
//    private static void getFactors(int number) {
//        List<Integer> factors = new ArrayList<>();
//
//        for (int i = 1; i <= number; i++) {
//            if (number <= 1) System.out.println("invalid input");
//            if (number % i == 0) factors.add(i);
//        }
//        System.out.println("factors of: " + number + " => " + factors);
//        if (factors.toArray().length < 2)
//            System.out.println("invalid input");
//
//        else if (factors.toArray().length > 3) {
//            System.out.println(number + " not a prime number ");
//        } else System.out.println(number + " is a prime number");
//    }

}



