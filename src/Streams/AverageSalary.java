package Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AverageSalary {
    public static void main(String[] args) {
        //highest average salary
        //highest salary
        List<Employee> employeeList = List.of(
                new Employee(1, "Alice","IT", 24000.0),
                new Employee(2, "Bob","IT", 10000.0),
                new Employee(3, "Cathrin","Admin", 8000.0),
                new Employee(4, "David","IT", 7000.0),
                new Employee(5, "Emi","Admin", 4000.0),
                new Employee(6, "Fenelin","RF Manager", 80000.0),
                new Employee(7, "Gebi","RF Manager", 50000.0),
                new Employee(7, "Gebi","RF Manager", 50000.0),
                new Employee(7, "Alice","RF Manager", 50000.0),
                new Employee(7, "Alice","RF Manager", 50000.0),
                new Employee(7, "Gebi","RF Manager", 50000.0)
        );

        List<Employee> sort = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .toList();
        System.out.println(sort);

        List<Employee> reverseSort = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .toList();
        System.out.println(sort);

        //highest salary
        Employee highestSalary = employeeList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
        System.out.println("name: "+highestSalary.id+" highestSalary "+highestSalary.getSalary());

        double avgSalary = employeeList.stream().mapToDouble(Employee::getSalary).average().orElse(0);
        System.out.println("avgSalary: "+avgSalary);

        Map<String, Double> avgSalByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("avgsalByDep: "+avgSalByDept);

        //highest paid employee by dept
        Map<String, Optional<Employee>> highPaidEmpByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println("highPaidEmpByDept: "+highPaidEmpByDept);

        //find all dept with more than 2 employees
        Map<String, Long> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        List<String> empMore2 = map.entrySet().stream().filter(e -> e.getValue() > 2).map(Map.Entry::getKey).toList();
        System.out.println("map: "+map);
        System.out.println("empMore2: "+ empMore2);

        //dept with highest avg salary
        Map<String, Double> avgSalData = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        Map.Entry<String, Double> highAvgsal = avgSalData.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow();
        System.out.println("avgSalData : "+avgSalData+" highAvgSal : "+highAvgsal);

        //most frequent character in a string
        String fruits = "banana";
        Map<Character, Long> mapFru = fruits.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map.Entry<Character, Long> freqChar = mapFru.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow();
        System.out.println("freqChar: "+freqChar);


        //find 1st non repeating char in string
        String input = "swiss";
        Map<Character, Long> map1 = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        Optional<Map.Entry<Character, Long>> firstNRCharacter = map1.entrySet().stream()
                .filter(entry -> entry.getValue() == 1).findFirst();
        System.out.println("firstNRCharacter: "+firstNRCharacter);

        //most common occurence of first letter among all employee names
        Map<Character, Long> map2 = employeeList.stream()
                .map(e -> e.getName().charAt(0)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Optional<Map.Entry<Character, Long>> mostOccFrstLetter = map2.entrySet().stream().max(Map.Entry.comparingByValue());
        System.out.println("mostOccFrstLetter : "+mostOccFrstLetter);


    }
}
