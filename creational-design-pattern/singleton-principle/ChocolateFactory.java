

public class ChocolateFactory {
    public static void main(String[] args) {
     
     
        ChocolateBoiler boiler1=ChocolateBoiler.getInstance();
        ChocolateBoiler boiler2=ChocolateBoiler.getInstance();

     boiler1.fill();
     boiler1.boil();
     boiler1.drain();
    
    System.out.println("boiler 1 & boiler 2 is same? :"+(boiler1 == boiler2));
    }
}
