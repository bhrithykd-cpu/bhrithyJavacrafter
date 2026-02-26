package Streams;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurence {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple","banana","apple","kiwi","apple","kiwi");
        Map<String, Long> countOcc
                = fruits.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("countOcc: "+countOcc);

    }


}
