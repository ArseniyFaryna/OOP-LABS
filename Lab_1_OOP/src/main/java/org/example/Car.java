package org.example;

public class Car extends Vehicle{

    private final String nameOfMarket;
    private final String middleTimeOfDelivery;

    public Car(String brand, String model, int year, double price, String originCountry, String nameOfMarket, String middleTimeOfDelivery) {
        super(brand, model, year, price, originCountry);
        this.nameOfMarket = nameOfMarket;
        this.middleTimeOfDelivery = middleTimeOfDelivery;
    }

    @Override
    public void getManufacturerInfo() {
        print("Company name is: " + nameOfMarket +
                ". Middle time for delivery is " + middleTimeOfDelivery + ".");
    }

    // Overloading method
    public void CalculateCustoms(double price, double exciseTax, double delivery) {
        double totalCustoms = (price * 0.01) + exciseTax;

        double total = totalCustoms + delivery;

        print("For the car, the total customs you should pay is " + total + "$");
    }

    @Override
    public void CalculateInsurance(double price, double otherTax) {
        double additionalInsurance = (price * 0.002);
        double totalInsurance = 0.0;
        if (2025 - year > 5){
            totalInsurance += 500;
        }
        else{
            totalInsurance += 100;
        }
        totalInsurance += additionalInsurance;
        print("Total insurance for normal car is " + totalInsurance + "$");
    }

    // Encapsulation
    private void print(String str){
        System.out.println(str);
    }

    @Override
    public String toString() {
        return "Car, " +  super.toString() +
                ", company = " + nameOfMarket +
                ", middleTimeOfDelivery = " + middleTimeOfDelivery;
    }
}
