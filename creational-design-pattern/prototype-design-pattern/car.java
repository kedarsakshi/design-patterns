
interface  carPrototype{
    carPrototype clone();
    
}

class thar implements carPrototype{

    @Override
    public carPrototype clone(){
        return new thar();
    }

    @Override
    public String toString(){
        return "thar";
    }
}

class creta implements carPrototype{

    @Override
    public carPrototype clone(){
        return new creta();
    }
    @Override
    public String toString(){
        return "creta";
    }

}

public class car {
    public static void main(String[] args) {
        carPrototype cPrototype=new thar();
        carPrototype cPrototype2=new creta();


         System.out.println("orignal thar : "+cPrototype);
       System.out.println("orignal creta : "+cPrototype2);

       carPrototype tharClone=cPrototype.clone();
       carPrototype cretaClone=cPrototype2.clone();

       System.out.println("clone thar : "+tharClone);
       System.out.println("clone creta : "+cretaClone);
    }
}
