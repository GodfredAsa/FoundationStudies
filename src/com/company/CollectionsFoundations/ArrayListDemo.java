package com.company.CollectionsFoundations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ArrayListDemo {

    static void sortElements(List<Integer> el){
        Collections.sort(el);
    }




    public static void main(String[] args) {
        List<Integer>  numberLists = new ArrayList<>();

        numberLists.add(1);
        numberLists.add(12);
        numberLists.add(9);
        numberLists.add(10);
        numberLists.add(5);

        sortElements(numberLists);


        Iterator<Integer> iterator = numberLists.iterator();
        while(iterator.hasNext()){
            int element = iterator.next();
            System.out.println("Element: " + element);
            if(element==9){
               iterator.remove();
            }
        }
        System.out.println(numberLists);

    }
}
