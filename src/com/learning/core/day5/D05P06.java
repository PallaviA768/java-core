package com.learning.core.day5;
import java.util.*;

class Person implements Comparable<Person> {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Person(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return id == person.id &&
                age == person.age &&
                Double.compare(person.salary, salary) == 0 &&
                Objects.equals(name, person.name);
    }

    @Override
    public int compareTo(Person otherPerson) {
        return Integer.compare(this.id, otherPerson.id);
    }
}

public class D05P06 {
    public static void main(String[] args) {
        TreeSet<Person> personSet = new TreeSet<>();

        // Predefined information for 6 persons
        personSet.add(new Person(1, "Alice", 22, 1500.0));
        personSet.add(new Person(2, "Bob", 30, 2500.0));
        personSet.add(new Person(3, "Charlie", 28, 1800.0));
        personSet.add(new Person(4, "David", 25, 2000.0));
        personSet.add(new Person(5, "John", 32, 1999.0));
        personSet.add(new Person(6, "Tom", 42, 3999.0));

        // Print persons whose age is greater than 25
        personSet.stream()
                .filter(person -> person.getAge() > 25)
                .forEach(System.out::println);
    }
}