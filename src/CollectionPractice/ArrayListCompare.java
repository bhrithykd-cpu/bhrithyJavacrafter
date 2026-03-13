package CollectionPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListCompare {
    public static void main(String[] args) {
        //sort and equal
        ArrayList<String> l1 = new ArrayList<>(Arrays.asList("A","B","C","D","F"));
        ArrayList<String> l2 = new ArrayList<>(Arrays.asList("A","B","C","D","E"));
        ArrayList<String> l3 = new ArrayList<>(Arrays.asList("B","A","C","D","E"));

        Collections.sort(l1);
        Collections.sort(l2);
        Collections.sort(l3);

        System.out.println(l1.equals(l2));
        System.out.println(l3.equals(l2));

        //compare
        ArrayList<String> l4 = new ArrayList<>(Arrays.asList("A","B","C","D","F"));
        ArrayList<String> l5 = new ArrayList<>(Arrays.asList("A","B","C","D","E"));

        //find additional element
        l4.removeAll(l5);
        System.out.println(l4);
        ArrayList<String> l6 = new ArrayList<>(Arrays.asList("A","B","C","D","F"));
        ArrayList<String> l7 = new ArrayList<>(Arrays.asList("A","B","C","D","E"));
        //missing element
        l7.removeAll(l6);
        System.out.println(l7);

        //find common elements
        ArrayList<String> l8 = new ArrayList<>(Arrays.asList("A","B","C","D","F"));
        ArrayList<String> l9 = new ArrayList<>(Arrays.asList("A","B","C","D","E"));

        l9.retainAll(l8);
        System.out.println(l9);


    }
}
