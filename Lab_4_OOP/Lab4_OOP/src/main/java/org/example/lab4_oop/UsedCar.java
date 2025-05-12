package org.example.lab4_oop;

public class UsedCar extends Car {

    double mileage;
    double condition;
    public UsedCar(String brand, int year, double price, double engineVolume, String importMaker, double mileage, double condition) {
        super(brand, year, price, engineVolume, importMaker);
        this.mileage = mileage;
        this.condition = condition;
    }

    public double getConditionRate(){
        return condition;
    }

    public double getMileage() {
        return mileage;
    }
}
