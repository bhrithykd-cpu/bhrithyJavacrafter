package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Createstream {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice","Bob");
        System.out.println(names);
        //1.List-> Streams
        Stream<String> stream = names.stream();
        //2.Array -> Stream
        String[] lang = {"Java","C++","Python"};
        Stream<String> stream1 = Arrays.stream(lang);
        //3.
        Stream<Integer> intStream = Stream.of(1, 2, 3);
        Stream<String> strStream = Stream.of("abc", "ghi", "hjk");
        Stream<Double> limit = Stream.generate(Math::random).limit(5);
        System.out.println(limit);

    }
}
