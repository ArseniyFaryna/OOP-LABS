package org.example;

public abstract class Vehicle {

    private final String brand;
    private final String model;
    protected final int year;
    protected final double price;
    public String originCountry;

    public Vehicle(String brand, String model, int year, double price, String originCountry) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.originCountry = originCountry;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    // Abstract method
    public abstract void getManufacturerInfo();

    // VAT and method to be overload
    public void CalculateCustoms(double price, double exciseTax) {
        double totalCustoms = (price + (price * 0.1) + exciseTax);
        System.out.println("So customs you should pay is " + totalCustoms + "$");
    }

    public void CalculateInsurance(double price, double otherTax) {
        double totalInsurance = (price * 0.005) + 50;
    }

    @Override
    public String toString() {
        return  "brand = " + brand  +
                ", model = " + model +
                ", year = " + year +
                ", price = " + price + "$" +
                ", originCountry = " + originCountry;
    }
}
