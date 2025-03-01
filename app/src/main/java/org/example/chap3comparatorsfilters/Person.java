package org.example.chap3comparatorsfilters;

public record Person(String name, int age) {
    public int ageDiff(Person p) {
        return this.age() - p.age();
    }
}
