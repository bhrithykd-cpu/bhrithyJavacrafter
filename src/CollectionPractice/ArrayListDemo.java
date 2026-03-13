package CollectionPractice;

import java.lang.reflect.AnnotatedType;
import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        //create array
        int i[] = new int[4];
        i[3] = 100;
        System.out.println(i[0]);//no value
        System.out.println(i[3]); //value there printed
        //value for i[4] or i[-1] will not be there as size is mentioned will get ArrayIndexoutofboundsexception

        //move to dynamicArray
        //ArrayList ar = new ArrayList();//not crct not specifying type

        ArrayList<Object> ar = new ArrayList<Object>();
        ar.add(100);
        ar.add(200);
        ar.add("test");
        ar.add(12.33);
        ar.add(true);

        System.out.println(ar);
        System.out.println("bf: "+ar.size());

        ar.add(400);
        ar.add(500);

        System.out.println("af: "+ar.size());


        //combine 2 arrayList
        ArrayList<String> ar1 = new ArrayList<>(Arrays.asList("java","python","ruby","javascript","java"));
        ArrayList<String> ar2 = new ArrayList<>(Arrays.asList("Testing","devops"));

        //ar1.addAll(ar2);
        //System.out.println(ar1);
       /* ar1.addAll(2,ar2);
        System.out.println(ar1);

        ar1.clear();
        System.out.println(ar1);*/
        ArrayList<String> clonedArr = (ArrayList<String>) ar1.clone();
        System.out.println(clonedArr);
        System.out.println(ar1.contains("python"));//check wthere element is present
        System.out.println(ar1.contains("r"));

        ar1.indexOf("java");//find position ex it is in position 0
        System.out.println(ar1.indexOf("java"));

        ar1.lastIndexOf("java");//lastindex of element
        System.out.println(ar1.lastIndexOf("java"));

        ar1.lastIndexOf("c");//lastindex of element
        System.out.println(ar1.lastIndexOf("c"));

        /*ar1.remove("java");//with value as well as index can be removed
        System.out.println(ar1);*/

        ArrayList<Integer> ar3 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        ar3.removeIf(num -> num%2 ==0);//remove based on condition
        System.out.println(ar3);

        ar1.retainAll(Collections.singleton("java"));//retain the specified element
        System.out.println(ar1);

        ArrayList<Integer> subList = new ArrayList<Integer>( ar3.subList(1, 3));
        System.out.println(subList);

        ArrayList<String> names = new ArrayList<>
                (Arrays.asList("tom","jerry","chinchan","dora","buji"));
        //System.out.println(names.toArray().toString());//wrong
        Object arr[] = names.toArray();
        System.out.println(Arrays.toString(arr));
        for (Object o: arr){
            System.out.println(o);
        }


    }
}
