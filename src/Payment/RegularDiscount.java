package Payment;

public class RegularDiscount implements Discount{
    //OCP
    @Override
    public double apply(double price) {
        return price*0.95;
    }
}
