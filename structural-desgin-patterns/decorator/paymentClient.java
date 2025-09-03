// 💳 Decorator Design Pattern – Payment System Example
// 📌 Overview

// The Decorator Pattern allows adding new behaviors to objects dynamically without modifying their existing code.
// It’s useful when you want to keep the core class simple but still allow extensions like logging, security, or notifications.

// In this example, we demonstrate a Payment Processing System where we enhance the base payment functionality using decorators:

// Encrypting Payment Data

// Fraud Detection

// Notification Sending


 interface Payment {
void pay(double amount);
    
}
//basic payment
class basicpayment implements Payment{

    
    
@Override
public void pay(double amount) {
    
    System.out.println("processing payment of "+amount);
}
}

//Abstract Decorator
abstract class paymentDecorator implements Payment{

    protected Payment decoratorPayment;

    public paymentDecorator(Payment payment){
        this.decoratorPayment=payment;
    }

    @Override
    public void pay(double amount) {
        decoratorPayment.pay(amount);
    }

}

//payment encryption -decorator
class EncryptedPayment extends paymentDecorator{
    

    public EncryptedPayment(Payment payment){
        super(payment);
    }

    @Override
    public void pay(double amount) {
        System.out.println("Encrypting payment data...");
        super.pay(amount);
    }
    
}

//fraud check payment - decorator
class FraudCheckPayment extends paymentDecorator{

    public FraudCheckPayment(Payment payment){
        super(payment);
    }

    @Override
    public void pay(double amount) {
          System.out.println("Running fraud detection...");
        super.pay(amount);
    }
}

//notification payment after successfull payment - decorator
class notificationPayment extends paymentDecorator{

    public notificationPayment(Payment payment){
        super(payment);
    }

    @Override
    public void pay(double amount) {
         super.pay(amount);
      System.out.println("Sending notification: Payment successful!");
       
    }
}
public class paymentClient {
    public static void main(String[] args) {
        //basic payment
        Payment payment=new basicpayment();

        //add decorator 
        //for output sequence =>
        payment=new EncryptedPayment( new FraudCheckPayment(new notificationPayment(payment)));
       
        //execute
        payment.pay(250);
    }
}
