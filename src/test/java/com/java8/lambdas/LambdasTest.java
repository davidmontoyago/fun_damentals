package com.java8.lambdas;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertTrue;

public class LambdasTest {

    final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15, 17, 21);

    final Lambdas lambdas = new Lambdas();

    @Test
    public void filters_out_odd_numbers_from_the_collection() {
        List<Integer> evenNumbers = lambdas.filterOddNumbers(numbers);

        assertThat(evenNumbers, hasItems(2, 4, 6, 8, 10));
    }

    @Test
    public void returns_lambda_that_finds_odds() {
        Lambdas.OddIsGood<Integer> oddIsGood = lambdas.giveMeALambdaToIdentifyOddNumbers();
        assertTrue(oddIsGood.isOdd(1));
        assertFalse(oddIsGood.isOdd(2));
    }

    @Test
    public void removes_blank_strings_from_collection() {
        List<String> strings = Arrays.asList("", "       ", "foo", " ", "bar", null);
        List<String> nonEmptyStrings = lambdas.removeBlankStringsFrom(strings);

        assertThat(nonEmptyStrings, hasItems("foo", "bar"));
    }
}
