package Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(91,2,31,4,51,6,7,83,9,10,11);
        //find number greater than 10
        Optional<Integer> result = input.stream().filter(n -> n > 10).sorted()
                .findFirst();
        System.out.println(result.get());

        //find count of numbers greater than 5
        long res = input.stream().filter(n -> n > 5).count();
        List<Integer> res1 = input.stream().filter(n -> n > 5).collect(Collectors.toList());
        System.out.println(res1);
        System.out.println(res);

        //sum/product of all numbers in list
        Integer sum = input.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        List<Integer> input1 = Arrays.asList(5,6,7,8);

        Integer mul = input1.stream().reduce(1, (a, b) -> a * b);
        System.out.println(mul);

        //sum of even numbers in list
        Integer result1 = input1.stream().filter(n -> n % 2 == 0)
                .reduce(0, (a, b) -> a + b);
        System.out.println(result1);

        //maximum number in list
        Optional<Integer> result2 = input1.stream().reduce(Integer::max);
        Integer result3 = input1.stream().reduce(0, Integer::max);
        System.out.println(result2.get());

        //sum of squares of even numbers in list
        Integer result4 = input1.stream().filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, (a, b) -> a + b);
        System.out.println(result4);

        //find distinct elements from list
        List<Integer> input3 = Arrays.asList(5,16,7,7,18,9,9);
        Set<Integer> output = input3.stream().collect(Collectors.toSet());
        Set<Integer> set = new HashSet<Integer>(input3);
        List<Integer> output1 = input3.stream().distinct().toList();
        System.out.println(set);
        System.out.println(output);
        System.out.println(output1);

        //find average of all numbers in list
        List<Integer> input4 = Arrays.asList(5,6,7,8,9,10);
        double avg = input.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println(avg);
        double sum1 = input.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum1);

        //sort in ascending / descending



    }
}
