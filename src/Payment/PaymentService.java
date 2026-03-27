package Payment;

public class PaymentService {
    //DI + SRP
    private final Discount discount;
    private final PaymentRepository paymentRepository;
    private final NotificationService notificationService;

    //constructor injection
    PaymentService(Discount discount,PaymentRepository paymentRepository,NotificationService notificationService){
        this.discount = discount;
        this.paymentRepository = paymentRepository;
        this.notificationService = notificationService;
    }

    void makePayment(PaymentMethod paymentMethod,double amount){
        double finalAmount = discount.apply(amount);
        paymentMethod.pay(finalAmount);
        paymentRepository.save(new Payment(finalAmount,paymentMethod.getClass().getSimpleName()));
        notificationService.send("Payment of "+finalAmount+" done via "+paymentMethod.getClass().getSimpleName());
    }
}
