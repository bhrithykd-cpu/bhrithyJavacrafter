package OOPS;

public class Rectangle extends Shape{

    private double width, height;//y final

    public Rectangle(double width,double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width*height;
    }
}
