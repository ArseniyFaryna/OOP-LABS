package org.example;

public class Volkswagen implements Car {
    @Override
    public String getBrand() {
        return "Volkswagen passat B6";
    }

    @Override
    public int getYear() {
        return 2020;
    }

    @Override
    public double getPrice() {
        return 15000;
    }

    @Override
    public double getMileage() {
        return 75000;
    }

    @Override
    public String getColor() {
        return "Green";
    }

    @Override
    public String getMarketName() {
        return "Poland";
    }

    @Override
    public String getType() {
        return "Sedan";
    }

    @Override
    public double getCustomRating() {
        return 1;
    }
}
