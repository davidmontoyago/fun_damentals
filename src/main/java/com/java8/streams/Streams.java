package com.java8.streams;

import java.util.*;

public class Streams {

    public List<Integer> filterOutOdds(List<Integer> numbers) {
        // TODO implement me with streams, collectors & lambdas
        List<Integer> evens = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evens.add(number);
            }
        }
        return evens;
    }

    public Integer findFirstPrimeNumberIn(List<Integer> numbers) {
        for (Integer number : numbers) {
            boolean prime = true;
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime)
                return number;
        }
        return null;
    }

    public String concatPeoplesNames(List<Person> people) {
        // TODO transform & collect
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person : people) {
            stringBuilder
                    .append(person.getFirstName())
                    .append(" ")
                    .append(person.getLastName())
                    .append(", ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }

    public Map<String, List<Person>> groupByLastName(List<Person> people) {
        // TODO collect & group
        Map<String, List<Person>> groupedPeople = new HashMap<>();
        for (Person person : people) {
            if (groupedPeople.containsKey(person.getLastName())) {
                groupedPeople.get(person.getLastName()).add(person);
            } else {
                groupedPeople
                        .put(person.getLastName(), new ArrayList<>(Arrays.asList(person)));
            }
        }
        return groupedPeople;
    }

    public Map<Boolean, List<Integer>> partitionPrimes(List<Integer> numbers) {
        Map<Boolean, List<Integer>> partitionedPrimes = new HashMap<>();
        partitionedPrimes.put(Boolean.TRUE, new ArrayList<>());
        partitionedPrimes.put(Boolean.FALSE, new ArrayList<>());

        for (Integer number : numbers) {
            boolean prime = true;
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    prime = false;
                    break;
                }
            }
            partitionedPrimes.get(prime).add(number);
        }
        return partitionedPrimes;
    }

    public Map<String, Long> countTimeZonesPerRegion() {
        Map<String, Long> counts = new HashMap<>();

        List<String> timeZones = Arrays.asList(TimeZone.getAvailableIDs());
        for (String timeZone : timeZones) {
            if (timeZone.contains("/")) {
                String region = timeZone.substring(0, timeZone.indexOf("/"));
                if (!counts.containsKey(region)) {
                    counts.put(region, 1L);
                } else {
                    counts.put(region, counts.get(region) + 1);
                }
            }
        }
        return counts;
    }

}
