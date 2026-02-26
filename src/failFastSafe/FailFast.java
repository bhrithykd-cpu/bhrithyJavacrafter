package failFastSafe;

 import java.util.*;
 import java.util.concurrent.CopyOnWriteArrayList;

public class FailFast {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");

        // Thread 1: iterates
        new Thread(() -> {
            try {
                for (String s : list) {
                    System.out.println(s);
                    Thread.sleep(50);
                }
            } catch (Exception e) {
                System.out.println("Thread 1 Exception: " + e);
            }
        }).start();

        // Thread 2: modifies
        new Thread(() -> {
            try {
                Thread.sleep(20);
                list.add("C");
            } catch (Exception e) {
                System.out.println("Thread 2 Exception: " + e);
            }
        }).start();
    }
}

