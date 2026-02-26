package failFastSafe;

import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafe {
    public static void main(String[] args) {

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");
        //thread 1
        new Thread (()->{
            try{
               Thread.sleep(50);
            }catch (Exception e){
                System.out.println("error in thread1");
            }
            for(String s :list){
                System.out.println(s);
            }

        }).start();

        //thread2
        new Thread (()->{
            try{
                list.add("C");
                Thread.sleep(20);
            }catch (Exception e){
                System.out.println("error in thread2");
            }

        }).start();

    }

}
