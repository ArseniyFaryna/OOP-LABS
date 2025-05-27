package org.example;

public class DeliveryCostDecorator extends CalculatorDecorator {

    private final double deliveryCost;

    public DeliveryCostDecorator(CalculateFullPrice calculateFullPrice, double deliveryCost) {
        super(calculateFullPrice);
        this.deliveryCost = deliveryCost;
    }

    @Override
    public double calculatePrice(Car car, double tax) {
        return super.calculatePrice(car, tax) + deliveryCost;
    }
}
