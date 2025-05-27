package org.example;

public class BMW implements Car{

    @Override
    public String getBrand() {
        return "BMW X7";
    }

    @Override
    public int getYear() {
        return 2021;
    }

    @Override
    public double getPrice() {
        return 50000;
    }

    @Override
    public double getMileage() {
        return 10000;
    }

    @Override
    public String getColor() {
        return "Black";
    }

    @Override
    public String getMarketName() {
        return "France";
    }

    @Override
    public String getType() {
        return "Jeep";
    }

    @Override
    public double getCustomRating() {
        return 1.25;
    }
}
