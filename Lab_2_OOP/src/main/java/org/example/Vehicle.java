package org.example;

import java.util.*;


public abstract class Vehicle implements CalculateCredit{

    private final String brand;
    private final String model;
    protected final int year;
    protected final double price;
    public String originCountry;
    protected double lastInsurance;

    private final RepairHistory repairHistory = new RepairHistory();

    public Vehicle(String brand, String model, int year, double price, String originCountry) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.originCountry = originCountry;
    }

    public RepairHistory getRepairHistory() {
        return repairHistory;
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

    public void setLastInsurance(double lastInsurance) {
        this.lastInsurance = lastInsurance;
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
        return  "brand = " + brand  + "\n" +
                ", model = " + model + "\n" +
                ", year = " + year + "\n" +
                ", price = " + price + "$" + "\n" +
                ", originCountry = " + originCountry + "\n";
    }
//    Inner class
    public class RepairHistory{
        private final List<String> history = new ArrayList<>();

        public void addHistory(String string) {
            history.add(string);
        }

        public void printServiceHistory() {
            if (history.isEmpty()){
                System.out.println("There are nothing to print!");
            }
            for (String string : history) {
                System.out.println(string);
            }
        }
    }
}
