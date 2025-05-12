package org.example.lab4_oop;

public enum Market {
    GERMANY(1.1),
    USA(1.5),
    NETHERLANDS(1.3),
    POLAND(1.8),
    UKRAINE(2.0),
    FRANCE(2.5),
    ENGLAND(2.8),
    ITALY(1.7);

    private final double marketTax;
    Market(double marketTax) {
        this.marketTax = marketTax;
    }

    public double getMarketTax() {
        return marketTax;
    }

}
