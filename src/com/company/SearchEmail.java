package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SearchEmail {

    public static void main(String[] args) {
        System.out.println(findEmail("fred@gamil.com"));
    }



    private static List<String> getEmails(){
        return Arrays.asList("fred@gamil.com", "seth@gmail.com");
    }


    private static Optional<String> findEmail(String search){
        return getEmails().stream()
                .filter(email -> email.equals(search))
                .findFirst();
    }
}
