package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
    public static void main(String[] args){
        System.out.println("convert list to Map with streams");

        List<User> usersList = Arrays.asList(
                new User("1","Alice"),
                new User("2","WonderLand"),
                //new User("3","BorderLand"));
                new User("1","BorderLand"),
                new User("1","horderLand"));
        //no duplicates
       /*Map<String, String> usersMap = usersList.stream().collect(Collectors.toMap(
                User::getUserName,
                User::getPassword
        ));
        System.out.println("map: "+usersMap);*/
        //same value no prblm, same key will get duplicate error
        //Exception in thread "main" java.lang.IllegalStateException: Duplicate key 1 (attempted merging values Alice and Alice)
        Map<String, String> usersDupMap = usersList.stream().collect(Collectors.toMap(
                User::getUserName,
                User::getPassword,
                (existing,duplicate) -> existing
        ));
        System.out.println("map: "+usersDupMap);
    }
}
