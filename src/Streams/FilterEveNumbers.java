package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterEveNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //find even numbers
        //note: to reduce use filter
        List<Integer> output = numbers.stream()
                .filter(e -> e % 2 == 0)//intermediate
                .collect(Collectors.toList());//terminal
        System.out.println(output);

        //find square of even numbers
        //note: transform  or map to other value
        List<Integer> square = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> sqList = square.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(sqList);

        //find square of even numbers
        //squareEvenNumbers
        List<Integer> squareEven = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> res = squareEven.stream().filter(n -> n % 2 == 0).map(n -> n * n)
                .toList();
        System.out.println(res);



    }

}
