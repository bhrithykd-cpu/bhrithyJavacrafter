package Streams;

public class User {
    String userName;
    String password;

    //if this constructor is notgiven what will happen
    //If you don’t define any constructor at all, Java will automatically provide a default (no-arg) constructor like
    //Employee() { }
    // we will get error in StreamsTest.java line no 9 new User("1","Alice") as below
    // constructor Employee in class Employee cannot be applied to given types;
    //  required: no arguments
    //  found: int, String
    //  reason: actual and formal argument lists differ in length
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
