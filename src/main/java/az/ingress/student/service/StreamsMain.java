package az.ingress.student.service;

import java.util.Arrays;
import java.util.List;

public class StreamsMain {

    public static void main(String[] args) {
        StreamsMain main = new StreamsMain();
        main.process();

        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
                .stream()
                .reduce((s,s1)->{return "c";})
                .filter(s -> s.startsWith("c") && s.endsWith("c"))
                .map(String::toUpperCase)
                .get();
    }

    private void process() {
        List<Person> persons =
                Arrays.asList(
                        new Person("David", 10),
                        new Person("Max", 18),
                        new Person("Peter", 2),
                        new Person("Peter", 25),
                        new Person("Pamela", 23)
                );

        persons
                .stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
                .ifPresent(System.out::println);    // Pamela


        persons
                .stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
                .ifPresent(System.out::println);    // Pamela
    }

    class Person {

        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }


}
