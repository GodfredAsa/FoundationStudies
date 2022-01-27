package com.company.Parallelizing;

import java.util.stream.LongStream;

public class FB05Paralleling {
    public static void main(String[] args) {

        long time = System.currentTimeMillis();

        System.out.println(LongStream.range(0, 1000_000_000)
                .parallel()
                .sum());

        System.out.print("time taken to run: ");
        System.out.println( System.currentTimeMillis() - time);





    }
}
