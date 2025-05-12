package org.example.lab4_oop;

public enum MarketForUsedCar {

    GERMANY(0.8),
    USA(0.9),
    NETHERLANDS(0.5),
    POLAND(0.6),
    UKRAINE(0.9),
    FRANCE(1.0),
    ENGLAND(1.5),
    ITALY(1.1);

    private final double marketTaxForUsedCar;
    MarketForUsedCar(double marketTaxForUsedCar) {
        this.marketTaxForUsedCar = marketTaxForUsedCar;
    }

    public double getMarketForUsedCarTax() {
        return marketTaxForUsedCar;
    }


}
