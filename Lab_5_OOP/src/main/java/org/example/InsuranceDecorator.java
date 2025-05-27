package org.example;

public class InsuranceDecorator extends CalculatorDecorator{

    private final double additionalTax;

    public InsuranceDecorator(CalculateFullPrice wrappedCalculateFullPrice, double additionalTax) {
        super(wrappedCalculateFullPrice);
        this.additionalTax = additionalTax;
    }

    @Override
    public double calculatePrice(Car car, double tax) {
        return (super.calculatePrice(car, additionalTax) * car.getCustomRating()) + additionalTax;
    }
}
