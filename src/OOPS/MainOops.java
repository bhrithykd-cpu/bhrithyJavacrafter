package OOPS;

public class MainOops {

    public static void main(String[] args) {
        Shape s1 = new Rectangle(10,5);
        Shape s2 = new Circle(8);
        System.out.println("Rectangle area: "+s1.area());
        System.out.println("Circle area: "+s2.area());
    }

}
