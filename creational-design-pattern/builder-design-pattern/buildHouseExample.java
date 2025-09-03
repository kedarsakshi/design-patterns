// 🏠 Builder Design Pattern – House Example
// 📌 Overview

// The Builder Design Pattern is a creational design pattern that allows step-by-step construction of complex objects.
// Instead of having constructors with multiple parameters (telescoping constructors problem), the Builder pattern provides a clean way to build objects with optional and mandatory attributes.

// This project demonstrates the Builder Pattern using a House example.

// 📖 Problem

// When building objects like a House, there may be multiple optional attributes (garage, swimming pool, garden, etc.).
// Using constructors for every combination leads to messy and hard-to-maintain code.

// ✅ The Builder Pattern solves this by:

// Building objects step by step.

// Providing method chaining (fluent API).

// Making code more readable and flexible.





class house{
    private String structure;
    private String roof;
    private String foundation;
    private boolean hasGarage;
        private boolean hasSwimmingPool;
        private boolean hasGarden;

        private house(houseBuilder builder){
            this.foundation=builder.foundation;
            this.roof=builder.roof;
            this.structure=builder.structure;
            this.hasGarage=builder.hasGarage;
            this.hasGarden=builder.hasGarden;
            this.hasSwimmingPool=builder.hasSwimmingPool;
        }

        @Override
        public String toString() {
            return "House [foundation=" + foundation + 
                ", structure=" + structure + 
                ", roof=" + roof +
                ", hasGarage=" + hasGarage +
                ", hasSwimmingPool=" + hasSwimmingPool +
                ", hasGarden=" + hasGarden + "]";
        }

        public static class houseBuilder{
         private String structure;
        private String roof;
        private String foundation;
        private boolean hasGarage;
        private boolean hasSwimmingPool;
        private boolean hasGarden;

        
        // Methods to set values

        public houseBuilder setStructure(String structure){
            this.structure=structure;
            return this;
        }

        public houseBuilder setFoundation(String foundation){
            this.foundation=foundation;
            return this;

        }

        public houseBuilder setRoof(String roof){
            this.roof=roof;
            return this;
        }

        public houseBuilder setGarage(boolean hasGarage){
            this.hasGarage=hasGarage;
            return this;
        }
        public houseBuilder setSwimmingPool(boolean hasSwimmingPool){
            this.hasSwimmingPool=hasSwimmingPool;
            return this;
        }

        public houseBuilder setGarden(boolean hasGarden){
            this.hasGarden=hasGarden;
            return this;
        }

         // Final step: build() creates the House object
        public house build(){
            return new house(this);
        }
        }
    
}

public class buildHouseExample {
    public static void main(String[] args) {
        house simpleHouse=new house.houseBuilder()
                                .setFoundation("Concrete")
                                .setStructure("Wood")
                                .setRoof("Tiles")
                                .setGarage(false)
                                .setSwimmingPool(false)
                                .setGarden(true)
                                .build();

                                System.out.println(simpleHouse);
    }
}
