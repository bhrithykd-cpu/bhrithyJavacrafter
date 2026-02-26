package Streams;

import java.util.List;

public class AveragePerson {
    public static void main(String[] args) {


        List<Person> personList = List.of(new Person("Alice", 14),
                new Person("Bob", 24),
                new Person("David", 32),
                new Person("Cathrin", 18),
                new Person("Fenelin", 20));
        double avg = personList.stream().mapToInt(Person::getAge).average().orElse(0);
        System.out.println("avg age:"+avg);
    }
}
