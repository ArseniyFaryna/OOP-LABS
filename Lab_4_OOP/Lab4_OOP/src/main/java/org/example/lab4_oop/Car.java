package org.example.lab4_oop;

public class Car{

    private final String brand;
    private final int year;
    private final double price;
    private final double engineVolume;
    private final String importMaker;
    private Market market;

    public Car(String brand, int year, double price, double engineVolume, String importMaker) {
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.engineVolume = engineVolume;
        this.importMaker = importMaker;
        this.market = Market.valueOf(importMaker.toUpperCase()); // виправлено
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public String getImportMaker() {
        return importMaker;
    }

    public Market getMarket() {
        return market;
    }

}
