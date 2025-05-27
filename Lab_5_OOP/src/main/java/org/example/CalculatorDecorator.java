package org.example;

public abstract class CalculatorDecorator implements CalculateFullPrice {

    protected final CalculateFullPrice wrappedCalculateFullPrice;

    public CalculatorDecorator(CalculateFullPrice wrappedCalculateFullPrice) {
        this.wrappedCalculateFullPrice = wrappedCalculateFullPrice;
    }

    @Override
    public double calculatePrice(Car car, double tax) {
        return wrappedCalculateFullPrice.calculatePrice(car, tax);
    }
}
