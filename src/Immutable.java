import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Immutable {
    public static void main(String[] args) {
        List<String> myList = List.of("Hello","World");
        Set<String> mySet = Set.of("Hello","World");

        //boolean add = myList.add("!");
        //System.out.println(add);

        List<String> list = Arrays.asList("Hello", "World");
        System.out.println(list);
    }
}
