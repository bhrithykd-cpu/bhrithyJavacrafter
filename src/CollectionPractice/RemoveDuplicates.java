package CollectionPractice;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> number = new ArrayList<Integer>(Arrays.asList(1,1,2,9,4,5,3,4,5,6,7,8,9));
        //1.LinkedHashSet

        HashSet<Integer> set = new HashSet<>(number);//does not maintain insertion order
        System.out.println(set);

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(number);//maintains insertion order
        System.out.println("link"+linkedHashSet);

        //2.streams
        List<Integer> uniqueList = number.stream().distinct().toList();
        System.out.println(uniqueList);


    }
}
