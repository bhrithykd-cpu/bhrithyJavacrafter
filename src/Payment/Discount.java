package Payment;

public interface Discount {
    //OCP
    double apply(double price);
}
