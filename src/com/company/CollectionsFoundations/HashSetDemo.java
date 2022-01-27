package com.company.CollectionsFoundations;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

    static  void hashSetDemo(){
        Set<String>  set = new HashSet<>();

        set.add("a");
        set.add("b");
        set.add("a");

        System.out.println(set);
    }

    public static void main(String[] args) {

    hashSetDemo();

    Book book1 = new Book("Things Fall Apart", "Flintstones", 1985);
    Book book2 = new Book("Things Fall Apart", "Flintstones", 1985);


    Set<Book> setOfBooks = new HashSet<>();

//    HashSet<String>

    setOfBooks.add(book1);
    setOfBooks.add(book2);

        System.out.println(setOfBooks);

    }
}
