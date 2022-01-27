package com.company.CollectionsFoundations;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DequeDemo {

//    FIFO
    static  void queueTest(){
        Deque<String> deque = new ArrayDeque<>();
        deque.add("The Hawk and the Hen");
        deque.add("Things Fall Apart");
        deque.add("A time to seek");

//        removes method returns the remove object
        System.out.println(deque.remove());
    }

//    LIFO
    static void stackTest(){

        Stack<String> stack  = new Stack<>();
        stack.push("Tomatoes");
        stack.push("Pepper");
        stack.push("Onions");

        for (String s : stack) {
            System.out.println("element : " + s);
            if(s.equals("Pepper")){
                stack.pop();
            }
        }


    }

    public static void main(String[] args) {
      queueTest();
        System.out.println("-------------- stack --------------");
        stackTest();
    }
}
