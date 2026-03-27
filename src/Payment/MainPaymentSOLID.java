package Payment;

public class MainPaymentSOLID {
    public static void main(String[] args) {
        //Dependencies
        PaymentRepository paymentRepository = new PaymentRepository();
        NotificationService notificationService = new NotificationService();
        Discount discount = new VipDiscount();//OCP+DI
        PaymentService paymentService = new PaymentService(discount,paymentRepository,notificationService);
        //LSP Different Payment methods
        PaymentMethod card = new CardPayment();
        PaymentMethod upi = new UpiPayment();
        //Run payments
        paymentService.makePayment(card,1000);
        paymentService.makePayment(upi,500);

        //ISP optional refund only for card
        if(card instanceof Refundable){
            ((Refundable) card).refund(200);
        }
    }
}
