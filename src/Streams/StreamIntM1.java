package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamIntM1 {
    public static void main(String[] args) {
        System.out.println("----------------------------------");
        System.out.println("Sort list of Employees by salary");

        List<Employee> employeeList = Arrays.asList
                (new Employee(1,"Alice","IT",20000.0),
                 new Employee(1,"Alice","HR",45600.0),
                 new Employee(1,"Alice","IT",73400.0),
                 new Employee(1,"Alice","IT",38900.0),
                 new Employee(1,"Alice","IT",45200.0));

        List<Employee> sortAscEmpBySal = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary)).toList();
        System.out.println("sortEmployee by salary: "+sortAscEmpBySal);

        List<Employee> sortDescEmpBySal = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()).toList();
        System.out.println("sortEmployee by salary: "+sortDescEmpBySal);

        System.out.println("----------------------------------");
        System.out.println("calculate the average age of a list of person objects");

        List<Person> personList
                = Arrays.asList(new Person("Alice",25),
                new Person("Bob",30),
                new Person("Charlie",35),
                new Person("David",28),
                new Person("Eleza",45)
                );
        //Double avgAge = personList.stream().collect(Collectors.averagingDouble(Person::getAge));
        double avgAge1 = personList.stream().mapToInt(Person::getAge).average().orElse(0.0);
        System.out.println("avgAge : "+avgAge1);

        System.out.println("----------------------------------");
        System.out.println("Partitioning numbers in even and odd numbers");

        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        Map<Boolean, List<Integer>> partition = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("even : "+partition.get(true)+"odd : "+partition.get(false));

        System.out.println("----------------------------------");
        System.out.println("Group a list of words by their length");

        List<String> words = List.of("apple","bat","ball","cat","banana","dog");
        //IntStream wordlength = words.stream().mapToInt(String::length).peek(System.out::println);
        Map<Integer, List<String>> wordlength = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("wordLength : "+wordlength);

        System.out.println("----------------------------------");
        System.out.println("Count occurence of each element in a list");

        List<String> words1 = List.of("apple","banana","apple","apple","banana","jackfruit");
        Map<String, Long> countOccurence = words1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("countOccurence: "+countOccurence);

        System.out.println("----------------------------------");
        System.out.println("Group employees by department and calculate average salary");

        Map<String, Double> avgSalaryDep = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("avgSalaryDep : "+avgSalaryDep);

    }
}
