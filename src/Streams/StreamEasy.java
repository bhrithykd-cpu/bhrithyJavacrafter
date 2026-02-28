package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamEasy {
    public static void main(String[] args) {
        System.out.println("-------------------------------------");
        System.out.println("Find all distinct elements / remove duplicates ");
        List<Integer> numbers = Arrays.asList(10,1,2,2,3,5,8,8,9);
        List<Integer> distictNum = numbers.stream().distinct().toList();
        System.out.println("distinct num : "+distictNum);
        Set<Integer> distictSet = numbers.stream().collect(Collectors.toSet());
        System.out.println("distictSet : "+distictSet);
        HashSet<Integer> set = new HashSet<>(numbers);
        System.out.println("set : "+set);//set will not maintain insertion order

        System.out.println("-------------------------------------");
        System.out.println("Find Average of all numbers in list");
        List<Integer> num1 = List.of(1,2,3,4,5);
        double average = num1.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        OptionalDouble average1 = num1.stream().mapToInt(Integer::intValue).average();
        System.out.println("average : "+average1);
        System.out.println("average : "+average);

        System.out.println("-------------------------------------");
        System.out.println("sort list in ascending and ascending order");
        List<Integer> num2 = List.of(82,78,56,13,67,45,82,13);
        List<Integer> asc = num2.stream().distinct().sorted().toList();
        System.out.println("asc : "+asc);
        List<Integer> desc = num2.stream().distinct().sorted(Comparator.reverseOrder()).toList();
        System.out.println("desc : "+desc);

        System.out.println("-------------------------------------");
        System.out.println("count how many strings start with a specific letter like A");
        List<String> fruits = List.of("Apple","Banana","Avacado","Mango","Apricot");
        long strCount = fruits.stream()
                .filter(f -> f.startsWith("A"))
                //.peek(System.out::println)
        .count();
        System.out.println("strcount : "+strCount);

        System.out.println("-------------------------------------");
        System.out.println("join all strings in a list to into single comma seperated string");
        List<String> fruits1 = List.of("Apple","Banana","Avacado","Mango","Apricot");
        String joinFruits = fruits1.stream().collect(Collectors.joining(","));
        System.out.println("joinFruits: "+joinFruits);

        System.out.println("-------------------------------------");
        System.out.println("check if all elements are positive numbers");
        List<Integer> num3 = List.of(2,3,8,-1,0);
        //List<Integer> num3 = List.of(2,3,8);
        List<Integer> positiveElements = num3.stream().filter(n -> n >= 0).toList();
        System.out.println("positiveElements: "+positiveElements);
        boolean checkPositive = num3.stream().allMatch(n -> n > 0);
        System.out.println("checkPositive: "+checkPositive);

        System.out.println("-------------------------------------");
        System.out.println("check if any number is divisible by 3");
        List<Integer> num4 = List.of(2,6,9);
        //List<Integer> num4 = List.of(3,6,9);
        //boolean checkDivBy3 = num4.stream().allMatch(n -> n % 3 == 0);
        boolean checkDivBy3 = num4.stream().anyMatch(n -> n % 3 == 0);
        System.out.println(checkDivBy3);

        System.out.println("-------------------------------------");
        System.out.println("flatten list of list");
        List<List<Integer>> num5 = Arrays.asList(Arrays.asList(1,2,3)
                ,Arrays.asList(4,5)
                ,Arrays.asList(6,7,8));
        List<Integer> flatList = num5.stream().flatMap(List::stream).toList();
        System.out.println("flatList: "+flatList);

        System.out.println("-------------------------------------");
        System.out.println("first non-empty string in a list");
        List<String> fruits2 = List.of("","","Avacado","","Apricot");
        Optional<String> nonEmpty = fruits2.stream().filter(n -> !n.isEmpty()).findFirst();
        System.out.println("nonEmpty: "+nonEmpty);

        System.out.println("-------------------------------------");
        System.out.println("second highest number in a list");
        List<Integer> num6 = List.of(45,78,38,26,100);
        Optional<Integer> secondHighest = num6.stream()
                .sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println("secondHighest: "+secondHighest);

    }
}
