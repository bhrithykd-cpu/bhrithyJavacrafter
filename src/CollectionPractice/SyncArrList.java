package CollectionPractice;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class SyncArrList {
    public static void main(String[] args) {
        //1. Collections.synchronizedList()
        //Iteration block is synchronized
        //List itself is not thread-safe everywhere
        /*List<String> names = new ArrayList<>
                (Arrays.asList("tom","jerry","chinchan","dora","buji"));*/
        List<String> names = Collections.synchronizedList(new ArrayList<>
                (Arrays.asList("tom","jerry","chinchan","dora","buji")));

        synchronized (names){
           Iterator<String> it = names.iterator();
           while (it.hasNext()){
               System.out.println(it.next());
           }
        }

        //2.Copy
        CopyOnWriteArrayList nameList = new CopyOnWriteArrayList(Arrays.asList("tom","jerry","chinchan","dora","buji"));
        System.out.println("----------");
            Iterator<String> it = names.iterator();
            while (it.hasNext()){
                System.out.println(it.next());
            }

    }
}
