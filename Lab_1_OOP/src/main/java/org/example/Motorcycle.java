package org.example;

public class Motorcycle extends Vehicle {

    private final String nameOfMarket;
    private final String middleTimeOfDelivery;
    private final String vehicleCondition;
    private final String certificationAvailability;

    public Motorcycle(String brand, String model, int year, double price, String originCountry, String nameOfMarket, String middleTimeOfDelivery, String vehicleCondition, String certificationAvailability) {
        super(brand, model, year, price, originCountry);
        this.nameOfMarket = nameOfMarket;
        this.middleTimeOfDelivery = middleTimeOfDelivery;
        this.vehicleCondition = vehicleCondition;
        this.certificationAvailability = certificationAvailability;
    }

    @Override
    public void getManufacturerInfo() {
        System.out.println("Company name: " + nameOfMarket
        + "\nMiddle time for delivery: " + middleTimeOfDelivery
        + "\nVehicle condition: " + vehicleCondition
        + "\nCertification : " + certificationAvailability);
    }

    @Override
    public void CalculateInsurance(double price, double otherTax) {
        double totalInsurance = 0.0;
        if (2025 - year > 7){
            totalInsurance += 350;
        }
        else{
            totalInsurance += 75;
        }
        print("Insurance for motorcycle is " + totalInsurance);
    }

    // Overloading method
    public void CalculateCustoms(double price, double exciseTax, double delivery, double otherTax) {
        double totalCustoms = (price * 0.1) + exciseTax;

        double total = totalCustoms + otherTax + delivery ;

        print("For the motorcycle, the total customs you should pay is " + total + "$");
    }

    // Encapsulation
    private void print(String str){
        System.out.println(str);
    }

    @Override
    public String toString() {
        return "Motorcycle " + super.toString() +
                ", company = " + nameOfMarket +
                ", middleTimeOfDelivery = " + middleTimeOfDelivery +
                ", vehicleCondition = " + vehicleCondition +
                ", certification = " + certificationAvailability;
    }
}
