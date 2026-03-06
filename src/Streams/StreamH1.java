package Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamH1 {
    public static void main(String[] args) {
        System.out.println("----------------------------------");
        System.out.println("most common first letter");
        List<Employee> employeeList = Arrays.asList
                (new Employee(1,"Alice","IT",20000.0),
                        new Employee(2,"Bob","HR",45600.0),
                        new Employee(21,"Bobby","HR",89600.0),
                        new Employee(3,"Charles","IT",73400.0),
                        new Employee(4,"David","Finance",38900.0),
                        new Employee(4,"Dinesh","Finance",38900.0),
                        new Employee(4,"Daniel","Finance",38900.0),
                        new Employee(5,"Eleza","IT",45200.0));
        Optional<Map.Entry<Character, Long>> mostCmnFrstLet = employeeList.stream()
                .map(e -> e.getName().charAt(0))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue());
        System.out.println("mostCmnFrstLet: "+mostCmnFrstLet);

        System.out.println("---------complex-------------------------");
        System.out.println("Given a list of integers compute the average of every 3 element sliding window");

        List<Integer> input = Arrays.asList(4,8,15,16,23,42);
        int window = 3;
        List<Double> sliWin = IntStream.range(0, input.size() - 2)
                .mapToObj(i -> input.subList(i, i + window))
                //.flatMap(w -> w.stream()).toList();
                .map(w -> w.stream().mapToInt(Integer::intValue).average().orElse(0.0))
                .toList();


        System.out.println("sliWin: "+sliWin);

        System.out.println("---------complex-------------------------");
        System.out.println("find longest word in a sentence Ignoring case and punctuation");

        String sentence = "The quick, brown fox jumped over the lazy dog!";
        String[] senSpl = sentence.toLowerCase().replaceAll("[^a-z\\s]", "").split(" ");
        System.out.println("senSpl : "+Arrays.asList(senSpl));
        String longestWord = Arrays.stream(senSpl)
                .max(Comparator.comparing(String::length)).orElse("");
        System.out.println("longestWord : "+longestWord);

        System.out.println("---------complex-------------------------");
        System.out.println("top 3 most frequent words in a paragraph");

        String sentence2 = "Java is great. Java is object-oriented and great. Java streams are powerful, and Java is fun!";
        String[] senSpl1 = sentence2.toLowerCase().replaceAll("[^a-z\\s]", "").split(" ");
        Map<String, Long> mostFre = Arrays.stream(senSpl1)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("mostFre : "+mostFre);
        List<Map.Entry<String, Long>> mostFre1 = mostFre.entrySet().stream()
                .sorted( Map.Entry.<String, Long>comparingByValue().reversed()).limit(3).toList();
        System.out.println("mostFre1 : "+mostFre1);

        List<Map.Entry<String, Long>> sorted = mostFre.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()).toList();

        List<Long> top3MostFrq = sorted.stream().map(Map.Entry::getValue).distinct().limit(3).toList();
        System.out.println("top3MostFrq : "+top3MostFrq);

        List<Map.Entry<String, Long>> mostFre3 = sorted.stream()
                .filter(e -> top3MostFrq.contains(e.getValue())).toList();

        System.out.println("mostFre3 : "+mostFre3);

        System.out.println("---------complex-------------------------");
        System.out.println("reverse each words in a paragraph");

        String sent4 = "Java is powerful";
        String revString = Arrays.stream(sent4.split(" "))
                .map(e -> new StringBuilder(e).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println("revString: "+revString);
        String revString1 = Arrays.stream(sent4.split(" "))
                .map(e -> Arrays.stream(e.split(""))
                        .reduce("",(a,b)-> b+a))
                .collect(Collectors.joining(" "));
        System.out.println("revString1: "+revString1);






    }


}
