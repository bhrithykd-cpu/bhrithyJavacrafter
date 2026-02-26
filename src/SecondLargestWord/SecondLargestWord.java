package SecondLargestWord;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SecondLargestWord {
    public static void main(String[] args) {
        System.out.println("Hello missing number");

        String sentence = "Java programming language is powerful and versatile";

        String[] words = sentence.split(" ");

        // Sort words in descending order of length
        Arrays.sort(words, (a, b) -> b.length() - a.length());

        System.out.println("Second longest word: " + words[1]);
        List<String> names = new ArrayList<>(Arrays.asList("Bob", "Alice", "Charlie"));
        // Default method 'sort' in List interface
        names.sort(String::compareTo);

        System.out.println(names); // [Alice, Bob, Charlie]
        String sentence1 = "Java is a good programming language";
        String[] split = sentence1.split(" ");
        System.out.println(Arrays.toString(split));
        Optional secondLar = Arrays.stream(split)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .peek(System.out::println)
                .distinct().skip(1).findFirst();
        System.out.println(secondLar.get());
        List<Integer> arrList = Arrays.asList(11,2,31,4);
        Stream<Integer> streamInteger = arrList.stream();
        long evenList =
        arrList.stream()
                .filter(n -> n> 10).count();
        System.out.println(evenList);
        int[] nums = {0,1,2,3,5};
        int miss = missingNumber(nums);
        System.out.println("miss: "+miss);
        String sentence2 = "Java programming is very powerful and versatile";
        String[] stringArr = sentence2.split("\\s+");
        System.out.println("string: "+ Arrays.toString(stringArr));
        Optional<String> secondLargest = Arrays.stream(sentence.split("\\s+"))
                .sorted(Comparator.comparingInt(String::length).reversed())
                .skip(1)
                .findFirst();
        //secondLargest.forEach(System.out::println);
        System.out.println(secondLargest.get());
        //secondLargest.ifPresent(e -> System.out.println(e));
        Stream<String> arr = Arrays.stream(sentence.split("\\s+")).sorted();
        arr.forEach(System.out::println);
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = n;   // start with n

        for (int i = 0; i < n; i++) {
            xor ^= i ^ nums[i];
        }

        return xor;
    }


}
