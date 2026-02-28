package Streams;

import java.util.*;
import java.util.stream.Stream;

public class StreamSE {
    public static void main(String[] args) {
        System.out.println("Create streams in java");
        Stream<Integer> streamInt = Stream.of(1, 2, 3);
        streamInt.forEach(System.out::println);
        List<String> strList = Arrays.asList("bhrithy","deeksha");
        Stream<String> streamList = strList.stream();
        streamList.forEach(System.out::println);
        String[] strArray = {"jaya","bhrithy","deeksha","kannan"};
        Stream<String> streamArray = Arrays.stream(strArray);
        streamArray.forEach(System.out::println);
        Stream<Double> ran = Stream.generate(Math::random).limit(5);
        ran.forEach(System.out::println);
        //filter even num
        System.out.println("filter even num");
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> evenNum = numbers.stream().filter(n -> n % 2 == 0).toList();
        System.out.println(evenNum);
        System.out.println("convert to squares");
        List<Integer> sqnum = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> sqnumList = sqnum.stream().map(n -> n * n).toList();
        System.out.println(sqnumList);
        System.out.println("Square even num from list");
        List<Integer> sqEvNum = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> sqEvnumList = sqEvNum.stream().filter(n -> n%2 ==0 ).map(n ->n*n).toList();
        System.out.println(sqEvnumList);
        System.out.println("find first element greater than 10");
        List<Integer> grthanten = Arrays.asList(61,12,73,10,25,61,7,81,93,14);
        Integer res = grthanten.stream().filter(n -> n > 10)
                .sorted().findFirst().get();
        System.out.println(res);
        System.out.println("Count how many num greater than 5");
        List<Integer> nums = Arrays.asList(61,2,73,10,25,1,5,81,93,4);
        long count = nums.stream().filter(n -> n>5).count();
        System.out.println(count);
        System.out.println("Sum/product of all num ");
        List<Integer> number1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = number1.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        Integer product = number1.stream().reduce((a, b) -> a * b).get();
        System.out.println(product);
        System.out.println("sum of even num ");
        List<Integer> number2 = Arrays.asList(1,3);
        Integer sumEven = number2.stream()
                .filter(n -> n%2 == 0)
                .reduce(0,Integer::sum);
        System.out.println(sumEven);
        System.out.println("max number");
        List<Integer> number3 = Arrays.asList(10,89,45,67,100);
        Integer maxNum = number3.stream().reduce( Integer::max).get();
        System.out.println(maxNum);
        System.out.println("max number 1");
        Integer maxNum1 = number3.stream().max(Comparator.naturalOrder()).get();
        System.out.println(maxNum1);
        int maxNum2 = number3.stream().mapToInt(Integer::intValue).max().orElse(0);//orelse added if list is empty OptionalInt also
        System.out.println(maxNum2);
        //check with list empty
        int maxNum3 = number3.stream().mapToInt(Integer::intValue).max().orElseThrow(() -> new NoSuchElementException("List is empty"));
        System.out.println(maxNum3);
        System.out.println("sum of squ of even num ");
        List<Integer> input = Arrays.asList(1,2,3,4,5,6);
        Integer res1 = input.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n).reduce(0, Integer::sum);
        System.out.println(res1);
    }
}
