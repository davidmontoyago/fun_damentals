package com.java8.streams;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertEquals;

public class StreamsTest {

    Streams streams;

    @Before
    public void setUp() {
        streams = new Streams();
    }

    @Test
    public void filters_out_odd_numbers_from_the_collection() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 11, 13, 15);

        List<Integer> evens = streams.filterOutOdds(numbers);

        assertThat(evens, hasItems(2, 4, 6, 8));
    }

    @Test
    public void returns_first_prime_number_in_collection() {
        List<Integer> numbers = Arrays.asList(4, 6, 8, 9, 11, 27, 41);

        Integer firstPrime = streams.findFirstPrimeNumberIn(numbers);

        assertEquals(Integer.valueOf(11), firstPrime);
    }

    @Test
    public void concatenates_all_names_separated_by_comas() {
        List<Person> people = Arrays.asList(
                new Person("Albert", "Einstein"),
                new Person("Marie", "Curie"),
                new Person("Nikola", "Tesla"),
                new Person("Charles", "Darwin"));

        String names = streams.concatPeoplesNames(people);

        assertEquals("Albert Einstein, Marie Curie, Nikola Tesla, Charles Darwin", names);
    }

    @Test
    public void groups_people_by_last_name() {
        Person albert = new Person("Albert", "Einstein");
        Person ana = new Person("Ana", "Einstein");
        Person nikola = new Person("Nikola", "Tesla");
        Person anaTesla = new Person("Ana", "Tesla");
        Person thomas = new Person("Thomas", "Huxley");
        List<Person> people = Arrays.asList(
                albert,
                ana,
                nikola,
                anaTesla,
                thomas
        );

        Map<String, List<Person>> groupedPeople = streams.groupByLastName(people);

        List<Person> einsteins = groupedPeople.get("Einstein");
        assertThat(einsteins, hasItems(albert, ana));

        List<Person> teslas = groupedPeople.get("Tesla");
        assertThat(teslas, hasItems(nikola, anaTesla));

        List<Person> huxleys = groupedPeople.get("Huxley");
        assertThat(huxleys, hasItem(thomas));
    }

    @Test
    public void partitions_the_primes() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        Map<Boolean, List<Integer>> partitions = streams.partitionPrimes(numbers);

        assertThat(partitions.get(Boolean.FALSE), hasItems(4, 6, 8, 9, 10, 12, 14, 15));
        assertThat(partitions.get(Boolean.TRUE), hasItems(1, 2, 5, 7, 11));
    }

    @Test
    public void counts_timezones_per_region() {
        Map<String, Long> counts = streams.countTimeZonesPerRegion();

        assertEquals(counts.get("Africa"), Long.valueOf(54));
        assertEquals(counts.get("America"), Long.valueOf(164));
    }
}
