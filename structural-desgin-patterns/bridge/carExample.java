

abstract class Car{

    protected CarColor carcolor;

    protected Car(CarColor carcolor){
        this.carcolor=carcolor;
    }

    abstract void produce();

}



class Thar extends Car{

    Thar(CarColor carcolor){
        super(carcolor);
    }

    @Override
    void produce() {
        System.out.print("thar painted with ");
        carcolor.paint();
    }
}


class Creta extends Car{

    Creta(CarColor carcolor){
        super(carcolor);
    }

    @Override
    void produce() {
        System.out.print("Creta painted with ");
        carcolor.paint();
    }
}
 interface  CarColor {
    void paint();
    
}

class red implements CarColor{

    @Override
    public void paint() {
        System.out.println("red color");
    }
}

class white implements CarColor{
    @Override
    public void paint() {
        System.out.println("white color");
    }
}


public class carExample {
    public static void main(String[] args) {
        Car car=new Thar(new red());
        car.produce();;

        Car car2=new Creta(new white());
        car2.produce();
    }
}
