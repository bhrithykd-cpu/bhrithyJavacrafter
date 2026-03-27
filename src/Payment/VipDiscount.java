package Payment;

public class VipDiscount implements Discount{
    //OCP
    @Override
    public double apply(double price) {
        return price * 0.8;
    }
}
