// ## 🟢 Singleton Principle
// The **Singleton Pattern** ensures that a class has **only one instance** and provides a global point of access to it.  

// ### ✅ Example: Chocolate Factory
// We simulate a **Chocolate Boiler** where:
// - Only **one boiler instance** can exist.
// - It can be filled, boiled, and drained in sequence.
// - Multiple objects requesting the boiler still point to the **same instance**.


public class ChocolateBoiler{
    private static ChocolateBoiler uniqueInstance;

    private boolean empty;
    private boolean boiled;

    private ChocolateBoiler(){
        empty=true;
        boiled=false;
  
    }

    public static ChocolateBoiler getInstance(){
        if(uniqueInstance ==null){
            uniqueInstance=new ChocolateBoiler();
            System.out.println("chocolate boiler is created");
        }
        return uniqueInstance;
    }

    public void fill(){
        if(empty){
            empty=false;
            boiled=false;
            System.out.println("boiler filled with chocolate and milk");
        }
    }

    public void boil(){
        if(!empty && !boiled){
            boiled=true;

            System.out.println("boiling the mixture");
        }
    }
    public void drain(){
        if(!empty && boiled){
            empty=true;
            System.out.println("draining boiled the mixture");
        }
    }
}



