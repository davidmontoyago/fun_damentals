package com.java8.streams;

import java.util.stream.IntStream;

public class ParallelAverage {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        IntStream.range(0, Integer.MAX_VALUE)
                .parallel()
                .filter((x) -> x % 2 == 0)
                .average();

        System.out.println("parallel processing: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        IntStream.range(0, Integer.MAX_VALUE)
                .filter((x) -> x % 2 == 0)
                .average();

        System.out.println("serial processing: " + (System.currentTimeMillis() - start));
    }
}
