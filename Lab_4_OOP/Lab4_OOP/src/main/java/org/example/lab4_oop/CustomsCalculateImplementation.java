package org.example.lab4_oop;

import org.springframework.stereotype.Service;

@Service
public class CustomsCalculateImplementation implements CustomsCalculateService {

    @Override
    public double calculateImportFee(Car car) {

        double initialPrice = car.getPrice();
        double engineTax = car.getEngineVolume() * 75;

        double yearTax;
        if (car.getYear() >= 2018) {
            yearTax = car.getYear() * 5;
        } else {
            yearTax = car.getYear() * 20;
        }

        double marketTax = car.getMarket().getMarketTax();
        return initialPrice + engineTax + yearTax * marketTax;

    }

}
