package Payment;

public class PaymentRepository {
    //SRP
    void save(Payment payment){
        System.out.println("save payment of "+payment.amount+"via"+payment.method);
    }
}
