package Payment;

public class UpiPayment implements PaymentMethod{

    //no refund ISP satisfied
    @Override
    public void pay(double amount) {
        System.out.println("Paid "+amount+"using UPI");
    }
}
