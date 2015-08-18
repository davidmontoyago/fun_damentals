package com.java8.lambdas;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Lambdas {

    interface Filter<T> {
        boolean filter(T t);
    }

    static class Collections2 {
        public static <T> List<T> filter(List<T> input, Filter<T> filter) {
            List<T> result = new ArrayList<T>();
            for (T t : input) {
                if (filter.filter(t)) {
                    result.add(t);
                }
            }
            return result;
        }
    }

    public List<Integer> filterOddNumbers(List<Integer> numbers) {
        // TODO make me a one liner with lambdas
        return Collections2.filter(numbers, new Filter<Integer>() {
            public boolean filter(Integer integer) {
                return integer % 2 == 0;
            }
        });
    }

    interface OddIsGood<T> {
        boolean isOdd(T input);
    }

    public OddIsGood giveMeALambdaToIdentifyOddNumbers() {
        // TODO this is not returning a Lambda! return one
        return new OddIsGood<Integer>() {
            @Override
            public boolean isOdd(Integer number) {
                return number % 2 == 1;
            }
        };

    }

    public List<String> removeBlankStringsFrom(List<String> strings) {
        // TODO implement me with lambda & auto generated interface
        return Collections2.filter(strings, new Filter<String>() {
            @Override
            public boolean filter(String s) {
                return !StringUtils.isBlank(s);
            }
        });
    }

}
