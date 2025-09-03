// # 🍫 Adapter Design Pattern – Chocolate Factory Example

// ## 📖 Overview
// The **Adapter Pattern** is a **structural design pattern** that allows incompatible interfaces to work together.  
// It acts as a **bridge** between old (legacy) systems and new systems.

// In this example, we model a **Chocolate Factory** where:
// - The **Modern Factory** can produce *normal chocolate* directly.
// - Old machines can still produce *cocoa* and *sugar chocolates* but use different methods.
// - The **Adapter** is used to integrate old machines into the modern system.

// ---

// ## 🏗 Pattern Components
// 1. **Target Interface (`ChocolateFactory`)**
//    - Defines the standard method `makeChocolate(String type)` that clients use.

// 2. **Adaptee (OldChocolateMaker)**
//    - Legacy class that has its own methods like `makeCocoaChocolate()` and `makeSugarChocolate()`.

// 3. **Adapter (`ChocolateAdapter`)**
//    - Implements the target interface.
//    - Internally calls the appropriate method of the old machine depending on the chocolate type.

// 4. **Client (Main Method)**
//    - Requests chocolate without worrying if it's made by the modern factory or the old machine.







interface chocolateM {
void makeChocolate(String type);
    
}

class oldSugarMixture 
{

public void micSugarChocolate(String style){
System.out.println("Mixing Sugar Chocolate in style: " + style);
}

}

class oldCocoMachine{

     public void produceCocoaBlock(String flavor) {
        System.out.println("Producing Cocoa Block: " + flavor);
    }
}


class chocolateMachineAdapter implements chocolateM{
    oldSugarMixture oldsugarmixture;
    oldCocoMachine oldCocoMachine;

    @Override
    public void makeChocolate(String type) {
        
        if(type.equalsIgnoreCase("coco")){
            oldCocoMachine= new oldCocoMachine();
            oldCocoMachine.produceCocoaBlock("dark coco");
        }else if(type.equalsIgnoreCase("sugar")){
            oldsugarmixture=new oldSugarMixture();
            oldsugarmixture.micSugarChocolate("sweet milk");
        }else{
             System.out.println("Unknown chocolate type: " + type);
        }
        
    }
}

class modernChocolateFactory implements chocolateM{
    chocolateMachineAdapter adapter;

    @Override
    public void makeChocolate(String type) {
        if(type.equalsIgnoreCase("normal")){
            System.out.println("making normal chocolate bar");

        }else if(type.equalsIgnoreCase("coco" )|| type.equalsIgnoreCase("sugar")){
            adapter=new chocolateMachineAdapter();
            adapter.makeChocolate(type);
        }else{
            System.out.println("Chocolate type "+type+" not supproted");
        }
    }
}
public class chocolateMachine {
    public static void main(String[] args) {
        modernChocolateFactory factory=new modernChocolateFactory();

        factory.makeChocolate("normal");
        factory.makeChocolate("coco");
        factory.makeChocolate("sugar");
        factory.makeChocolate("nut");
    }
}
