package Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIM2 {
    public static void main(String[] args) {
        System.out.println("----------------------------------");
        System.out.println("highest paid employee in each department");

        List<Employee> employeeList = Arrays.asList
                (new Employee(1,"Alice","IT",20000.0),
                        new Employee(2,"Bob","HR",45600.0),
                        new Employee(21,"Bobby","HR",89600.0),
                        new Employee(3,"Charles","IT",73400.0),
                        new Employee(4,"David","Finance",38900.0),
                        new Employee(4,"David","Finance",38900.0),
                        new Employee(4,"David","Finance",38900.0),
                        new Employee(5,"Eleza","IT",45200.0));

        Map<String, Optional<Employee>> dept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment
                        ,Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println("dept :"+dept);

        System.out.println("----------------------------------");
        System.out.println("find all department with more than 2 Employees");

        List<String> deptMT2 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 2)
                .map(Map.Entry::getKey).toList();
        System.out.println("deptMT2: "+deptMT2);

        System.out.println("----------------------------------");
        System.out.println("find department with highest average salary");

        Map<String, Double> deptHighAvgSal = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment
                , Collectors.averagingDouble(Employee::getSalary)));
        Map.Entry<String, Double> deptHighAvgSal1 = deptHighAvgSal.entrySet().stream()
                .max(Map.Entry.comparingByValue()).orElseThrow();
        System.out.println("deptHighAvgSal1: "+deptHighAvgSal1);

        System.out.println("----------------------------------");
        System.out.println("find most frequent character in string");

        String input = "banana";
        Stream<Character> freqChar = input.chars().mapToObj(c -> (char) c);
        Map.Entry<Character, Long> freqChar1 = freqChar.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow();
        System.out.println("freqChar: "+freqChar1);

        System.out.println("----------------------------------");
        System.out.println("find first non repeating character in a string");

        String input2= "swiwiss";
        Optional<Map.Entry<Character, Long>> nonRepeat = input2.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting())).entrySet().stream()
                //.min(Map.Entry.comparingByValue()); //we might get 2 also so wrong
                        .filter(e -> e.getValue() == 1).findFirst();
        System.out.println("nonRepeat: "+nonRepeat);
    }


}
