package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamSE {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("Create streams in java");
        Stream<Integer> streamInt = Stream.of(1, 2, 3);
        List<String> intList = Arrays.asList("bhrithy","deeksha");
        Stream<String> streamList = intList.stream();
        String[] strArray = {"jaya","bhrithy","deeksha","kannan"};
        Stream<String> streamArray = Arrays.stream(strArray);
        Stream<Double> ran = Stream.generate(Math::random).limit(5);
    }
}
