// # 🌉 Bridge Design Pattern – Chocolate Factory Example

// ## 📖 Overview
// The **Bridge Pattern** is a **structural design pattern** that **decouples abstraction from implementation** so that both can evolve independently.  

// Think of it like a **bridge** that connects two separate hierarchies:
// - **Abstraction (what to do)** → e.g., Chocolate Types
// - **Implementation (how to do it)** → e.g., Chocolate Flavors

// ---

// ## 🏗 Pattern Components
// 1. **Abstraction (Chocolate)**
//    - Defines the interface for different chocolate types (`produce()`).
//    - Maintains a reference to an **Implementor** (`Flavor`).

// 2. **Refined Abstraction (DarkChocolate, MilkChocolate)**
//    - Extends abstraction and provides specialized behavior.

// 3. **Implementor (Flavor)**
//    - Defines the interface for flavor implementations (`addFlavor()`).

// 4. **Concrete Implementors (VanillaFlavor, HazelnutFlavor, etc.)**
//    - Provide specific implementations of flavors.

abstract class Chocolate{
    protected Flavor flavor;

    protected Chocolate(Flavor flavor){
        this.flavor=flavor;
    }

    abstract void produce();
}

class darkChocolate extends Chocolate{

    darkChocolate(Flavor flavor){
        super(flavor);
    }
    @Override
    void produce() {
        System.out.println("producing dark chocolate with ");
        flavor.addFlavor();
    }
}

class milkChocolate extends Chocolate{

    milkChocolate(Flavor flavor){
        super(flavor);
    }
    @Override
    void produce() {
        System.out.println("producing milk chocolate with ");
        flavor.addFlavor();
    }
}

 interface Flavor {
    void addFlavor();
    
}

class vanillaFlavor implements Flavor{

    @Override
    public void addFlavor() {
       System.out.println("vanilla flavor");
        
    }
}

class HazelnutFlavor implements Flavor{

    @Override
    public void addFlavor() {
        System.out.println(" Hazelnut Flavor ");
    }
}

public class chocolateFlavor {

    public static void main(String[] args) {
        Chocolate chocolate=new darkChocolate(new vanillaFlavor());
        chocolate.produce();

        Chocolate chocolate2=new milkChocolate(new HazelnutFlavor());
        chocolate2.produce();
    }
}