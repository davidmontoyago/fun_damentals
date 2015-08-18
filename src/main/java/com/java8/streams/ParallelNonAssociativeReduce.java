package com.java8.streams;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ParallelNonAssociativeReduce {

    public static void main(String args[]) {
        OptionalInt result = IntStream.range(1, 1000)
                .parallel()
                .reduce((a, b) -> a-b);

        System.out.println(result.getAsInt());

        result = IntStream.range(1, 1000)
                .reduce((a, b) -> a-b);

        System.out.println(result.getAsInt());
    }
}
