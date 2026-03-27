package Payment;

public class CardPayment implements PaymentMethod,Refundable{


    @Override
    public void pay(double amount) {
        System.out.println("Paid "+amount+"using Card");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded "+amount+"to Card");
    }
}
