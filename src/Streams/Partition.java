package Streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Partition {
    public static void main(String[] args) {
        List<Integer> partition = List.of(1,2,3,4,5,6,7,8,9,10);

        Map<Boolean, List<Integer>> data
                = partition.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("data: "+data);

        List<String> animals = List.of("dog","giraffe","goat","cat","cow","zebra");

        Map<Integer, List<String>> animalsData
                = animals.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("animalsData "+animalsData);
    }

}
