package org.example;

public class Ford implements Car {
    @Override
    public String getBrand() {
        return "Ford Focus";
    }

    @Override
    public int getYear() {
        return 2020;
    }

    @Override
    public double getPrice() {
        return 12000;
    }

    @Override
    public double getMileage() {
        return 15000;
    }

    @Override
    public String getColor() {
        return "White";
    }

    @Override
    public String getMarketName() {
        return "Sedan";
    }

    @Override
    public String getType() {
        return "Sedan";
    }

    @Override
    public double getCustomRating() {
        return 1.75;
    }
}
