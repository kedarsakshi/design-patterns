// # 🏭 Abstract Factory Pattern – Furniture Example

// ## 📌 Overview
// The **Abstract Factory Pattern** is a creational design pattern that allows you to create **families of related objects** without specifying their exact classes.  

// In this example, we demonstrate the pattern using **Furniture Factories**:
// - **Victorian Factory** → produces Victorian-style Chair and Sofa  
// - **Modern Factory** → produces Modern-style Chair and Sofa  

// The client (`FurnitureClient`) can use either factory to create products **without knowing the exact implementation**.

// ---

// ## 🛠 Structure
// - **Product Interfaces**
//   - `Chair` → `makeChair()`
//   - `Sofa` → `makeSofa()`
// - **Concrete Products**
//   - `VictorianChair`, `VictorianSofa`
//   - `ModernChair`, `ModernSofa`
// - **Abstract Factory**
//   - `FurnitureFactory` → defines methods `createChair()` and `createSofa()`
// - **Concrete Factories**
//   - `VictorianFactory` → creates Victorian furniture
//   - `ModernFactory` → creates Modern furniture
// - **Client**
//   - `FurnitureClient` → uses factories to build products



interface furniture {
 void make();
    
}

 interface chair {
    void makechair();
    
}

interface sofa {
void makesofa();
    
}

 interface coffetable {

    void makecoffetable();
}

class victorianchair implements chair{
    victorianchair(){
        System.out.println("victorian chair");
    }

    @Override
    public void makechair() {
        System.out.println("making victorian chair");
    }
}

class modernChair implements chair{
    modernChair(){
        System.out.println("modern chairs");
    }
    @Override
    public void makechair() {
        System.out.println("making nodern chairs");
    }
}

class victoriansofa implements sofa{
    victoriansofa(){
        System.out.println("victorian sofa");
    }
    @Override
    public void makesofa() {
        System.out.println("making victorian sofa");
    }
}

class modernSofa implements sofa{
    modernSofa(){
        System.out.println("modern sofa");
    }

    @Override
    public void makesofa() {
        System.out.println("making modern sofa");
    }
}

//making abstract factory interface

 interface factory {
chair createChair();
sofa createSofa();
    
}
//concrete factories

class modernFactory implements factory{
    @Override
    public chair createChair() {
        return new modernChair();
    }

    @Override
    public sofa createSofa() {
        return new modernSofa();
    }
}

class victorianFactory implements factory{

    @Override
    public chair createChair() {
        return new victorianchair();
    }

    @Override
    public sofa createSofa() {
        return new victoriansofa();
    }
}
public class furnitureClient {

    public static void main(String[] args) {

        //create and make vectorian chair and sofa
       factory victorianchair=new victorianFactory();
       chair vChair=victorianchair.createChair();
        vChair.makechair();

        factory victoriansofa=new victorianFactory();
        sofa vSofa=victoriansofa.createSofa();
        vSofa.makesofa();

System.out.println("--------------------------------------------");

 //create and make modern chair and sofa
        factory mFactory=new modernFactory();
        chair mChair=mFactory.createChair();
        mChair.makechair();

        factory mFactory2=new modernFactory();
        sofa mSofa=mFactory2.createSofa();
        mSofa.makesofa();

    }
}

//output--

// victorian chair
// making victorian chair
// victorian sofa
// making victorian sofa
// --------------------------------------------
// modern chairs
// making nodern chairs
// modern sofa
// making modern sofa