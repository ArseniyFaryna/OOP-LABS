package org.example;

public class Audi implements Car{
    @Override
    public String getBrand() {
        return "Audi A5";
    }

    @Override
    public int getYear() {
        return 2019;
    }

    @Override
    public double getPrice() {
        return 10000;
    }

    @Override
    public double getMileage() {
        return 25000;
    }

    @Override
    public String getColor() {
        return "Blue";
    }

    @Override
    public String getMarketName() {
        return "Germany";
    }

    @Override
    public String getType() {
        return "Sedan";
    }

    @Override
    public double getCustomRating() {
        return 1.35;
    }
}
