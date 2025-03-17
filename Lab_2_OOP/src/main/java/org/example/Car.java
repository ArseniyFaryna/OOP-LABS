package org.example;

public class Car extends Vehicle implements CalculateCredit{

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
        setLastInsurance(totalInsurance);
        print("Total insurance for normal car is " + totalInsurance + "$");
    }

    // Encapsulation
    private void print(String str){
        System.out.println(str);
    }

    @Override
    public String toString() {
        return "Car, " +  super.toString()  +
                ", company = " + nameOfMarket + "\n" +
                ", middleTimeOfDelivery = " + middleTimeOfDelivery;
    }

    @Override
    public void calculateMonthlyCredit(int year, double price, int month, double yearRate) {
        double totalCredits = 0;
        double rm = (yearRate / 100) / 12;
        if (2025 - year < 10){
            totalCredits = (price / 2) * (rm * Math.pow(1 + rm, month) / (Math.pow(1 + rm, month) - 1));
            String formatted = String.format("%.4f", totalCredits);
            print("Total credits is " + formatted + "$ per month for " + month + " months.");
        }
        else{
            double credit = (price / 2) / month;
            print("For first month credit is " + (credit + (price / 2) * rm) + "$");

            for (int i = 2; i <= month; i++) {
                double interest = (price / 2 - credit * (i - 1)) * rm;
                double monthlyPayment = credit + interest;
                String formatted = String.format("%.4f", monthlyPayment);
                print("For " + i + " month credit is " + formatted + "$");
            }
        }
    }

    @Override
    public void calculateInstallments(double price, int month, int firstDeposit) {
        double totalInstallments = (price - firstDeposit) / month;
        print("Deposit without percentage installments is " + totalInstallments + "$");
    }

}
