package Streams;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamH2 {
    public static void main(String[] args) {

        System.out.println("----------------------------------");
        System.out.println("find from a list of transaction find day with highest total spend");

        List<Transaction> transactionList = Arrays.asList(
                new Transaction("T1", LocalDate.of(2024,1,1),300.0),
                new Transaction("T2", LocalDate.of(2024,1,1),200.0),
                new Transaction("T3", LocalDate.of(2024,1,2),500.0),
                new Transaction("T4", LocalDate.of(2024,1,2),300.0),
                new Transaction("T5", LocalDate.of(2024,1,3),100.0)
        );

        Map.Entry<LocalDate, Double> highTot = transactionList.stream()
                .collect(Collectors.groupingBy(Transaction::getDate, Collectors.summingDouble(Transaction::getAmount)))
                .entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow();
        
        System.out.println("highTot : "+highTot);

        System.out.println("----------------------------------");
        System.out.println("categorise employees based on their salary (LOW/MEDIUM/HIGH) using streams");

        List<Employee> employeeList = Arrays.asList
                (new Employee(1,"Alice","IT",20000.0),
                        new Employee(2,"Bob","HR",45600.0),
                        new Employee(21,"Alice","HR",89600.0),
                        new Employee(3,"Charles","IT",73400.0),
                        new Employee(4,"David","Finance",38900.0),
                        new Employee(4,"Dinesh","Finance",38900.0),
                        new Employee(4,"Drago","Finance",138900.0),
                        new Employee(5,"David","IT",145200.0));

        Map<SalaryRange, List<Employee>> empSal = employeeList.stream()
                .collect(Collectors.groupingBy(e -> getSalaryRange(e.getSalary())));


        System.out.println("empSal : "+empSal);

        System.out.println("---------------------------------");
        System.out.println("Group characters by Uppercase vs lowercase vs digit vs other");

        List<Character> chars = Arrays.asList('A','b','3','Z','x','#','7','m','@');
        Map<CharCategory, List<Character>> charValue = chars.stream().collect(Collectors.groupingBy(ch -> getCharCategory(ch)));
        System.out.println("charValue : "+charValue);

        System.out.println("----------------------------------");
        System.out.println("Find all employees who worked in 3+ department");

        Map<String, List<Employee>> map3Dept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getName));
        List<String> map3Dept1 = map3Dept.entrySet().stream()
                .filter(e -> e.getValue().size() > 1)
                .map(Map.Entry::getKey).toList();
        System.out.println("map3Dept : "+map3Dept);
        System.out.println("map3Dept1 : "+map3Dept1);

        System.out.println("----------------------------------");
        System.out.println("Find Biagram Frequencies (Pair of consecutive words in paragraph");

        String sentence = "Java is great and java is fun. Java is powerful!";

        String[] sen1 = sentence.toLowerCase().replaceAll("[^a-z\\s]", "").split(" ");

        List<String> sen2 = IntStream.range(0, sen1.length - 1).mapToObj(i -> sen1[i]+" "+ sen1[i + 1]).toList();
        System.out.println("sen2 : "+sen2);
        Map<String, Long> sen3 = sen2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("sen3 : "+sen3);
    }

    private static SalaryRange getSalaryRange(Double salary) {
        if (salary < 50000) return SalaryRange.LOW;
        if (salary < 100000) return SalaryRange.MEDIUM;
        else return SalaryRange.HIGH;
    }

    private static CharCategory getCharCategory(char c){
        if (Character.isLowerCase(c)) return CharCategory.LOWERCASE;
        if (Character.isUpperCase(c)) return CharCategory.UPPERCASE;
        if (Character.isDigit(c)) return CharCategory.DIGIT;
       else return CharCategory.OTHER;
    }
}
