package org.example.chap3comparatorsfilters;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ComparatorExample {

    /*
    A comparison function, which imposes a total ordering on some collection of objects.
    Comparators can be passed to a sort method (such as Collections.sort or Arrays.sort)
    to allow precise control over the sort order.

    Functional interface so lambda expressions can be used
     */
    private Comparator<Person> compAsc = Person::ageDiff;
    private Comparator<Person> compDesc = compAsc.reversed();
    private Comparator<Person> byAgeComparator = Comparator.comparing(Person::age);
    private Function<Person, Integer> byAge = Person::age;
    private Function<Person, String> byName = Person::name;

    public List<Person> sortAscendingAge(final List<Person> persons) {
        return persons.stream()
                .sorted((p1, p2) -> p1.ageDiff(p2))
                .toList();
    }

    public List<Person> sortAscendingAgeMethodRef(final List<Person> persons) {
        return persons.stream()
                .sorted(Person::ageDiff)
                .toList();
    }

    public List<Person> sortDescendingAge(final List<Person> persons) {
        return persons.stream()
                .sorted(compDesc)
                .toList();
    }

    // Optional needed in case empy list, there will not be oldest
    public Optional<Person> findOldest(final List<Person> persons) {
        return persons.stream()
                .max(compAsc);
    }

    // comparing takes a function ans returns a Comparator
    public List<Person> sortAscendingName(final List<Person> persons) {
        return persons.stream()
                .sorted(Comparator.comparing(byName))
                .toList();
    }

    // chain functions that produce comparators
    public List<Person> sortAscendingAgeThenName(final List<Person> persons) {
        return persons.stream()
                .sorted(Comparator.comparing(byAge).
                        thenComparing(byName))
                .toList();
    }

    public Map<Integer, List<Person>> groupByAge(final List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(Person::age));
    }

    public Map<Integer, List<String>> namesGroupByAge(final List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(Person::age,
                        Collectors.mapping(Person::name, Collectors.toList())));
    }

    // group by first character
    // then reduce to Person with max age
    public Map<Character, Optional<Person>> oldestByInitial(final List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(p -> p.name().charAt(0),
                        Collectors.reducing(BinaryOperator.maxBy(byAgeComparator))));
    }
}
