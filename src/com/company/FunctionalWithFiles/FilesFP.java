package com.company.FunctionalWithFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;


public class FilesFP {

    public static void main(String[] args) throws IOException {

        Files.lines(Paths.get("file.txt"))
                .map(String::toUpperCase)
                .filter(word->word.length()>20)
                .sorted(Comparator.comparing(String::length).reversed())
                .forEach(System.out::println);


        
//        paths in the root of the project
        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);
    }



}
