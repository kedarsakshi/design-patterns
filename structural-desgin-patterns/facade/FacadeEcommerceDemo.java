
class CheckStockAvailable{

    public void checkStock(String product){
        System.out.println("Checking stock for product "+product);
    }
}

class Payment{

    public void makepayment(double amount){
        System.out.println("Processing payment of");
    }
}

class ShipOrder{
    public void shipOrder(String product){
        System.out.println("Shipping order of "+product);
    }
}

class Orderfacade{
    private CheckStockAvailable checkStockAvailable;
    private Payment payment;
    private ShipOrder shipOrder;

    public Orderfacade(){
      
        this.checkStockAvailable=new CheckStockAvailable();
        this.payment=new Payment();
        this.shipOrder=new ShipOrder();
    
    }

    public void placeOrder(String product , double amount){
        System.out.println("\nPlacing order...");
        checkStockAvailable.checkStock(product);
        payment.makepayment(amount);
        shipOrder.shipOrder(product);

        System.out.println("Order placed successfully!");
    }

}

public class FacadeEcommerceDemo {
    public static void main(String[] args) {
        Orderfacade order=new Orderfacade();
        order.placeOrder("laptop", 10000);
    }
}
