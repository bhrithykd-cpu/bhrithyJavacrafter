package CollectionPractice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class MapDemo {
    public static void main(String[] args) {
        //no order -  no indexing
        //stores data key value pair
        //key cannot be duplicate
        //one null key multiple null value
        //thread- safe not - unsynchronized
        HashMap<String,String> capitalMap = new HashMap<>();
        capitalMap.put("India","New Delhi");
        capitalMap.put("USA","WashingtonDC");
        capitalMap.put("UK","London");
        capitalMap.put("UK","London11");
        capitalMap.put(null,"Berlin");
        capitalMap.put(null,"LA");
        capitalMap.put("Russia",null);
        capitalMap.put("France",null);
        capitalMap.remove("Russia");

        System.out.println(capitalMap.get("India"));
        System.out.println(capitalMap.get("UK"));
        System.out.println(capitalMap.get(null));
        //System.out.println(capitalMap.get("Russia"));

        //iterate over the keys by using keyset
       Iterator<String> it = capitalMap.keySet().iterator();
       while (it.hasNext()){
           String key = it.next();
           String value = capitalMap.get(key);
           System.out.println("key: "+key+"value: "+value);
       }
        //Never call iterator.next() more than once in a single iteration unless you know exactly what you're doing.
       //iterate using entryset
        Iterator<Entry<String, String>> it1 = capitalMap.entrySet().iterator();
       while (it1.hasNext()){
           Entry<String, String> entry = it1.next();//should not use directly
           System.out.println("key : "+entry.getKey()+"value: "+entry.getValue());
       }
        System.out.println("---------------");
       //lambda java8
        capitalMap.forEach((k,v) -> System.out.println("key: "+k+"value: "+v));

    }
}
