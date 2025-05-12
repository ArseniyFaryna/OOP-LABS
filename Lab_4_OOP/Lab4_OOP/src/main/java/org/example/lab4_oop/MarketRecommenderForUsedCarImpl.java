package org.example.lab4_oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketRecommenderForUsedCarImpl implements MarketRecommenderForUsedCar{

    private final CalculateServiceForUsedCar calculateServiceForUsedCar;

    @Autowired
    public MarketRecommenderForUsedCarImpl(CalculateServiceForUsedCar calculateServiceForUsedCar) {
        this.calculateServiceForUsedCar = calculateServiceForUsedCar;
    }

    @Override
    public MarketForUsedCar recommendTheBestMarketForUsedCar(UsedCar usedCar) {
        MarketForUsedCar bestMarket = null;
        double lowestPrice = Double.MAX_VALUE;

        for (MarketForUsedCar marketForUsedCar : MarketForUsedCar.values()) {
            UsedCar tempCar = new UsedCar(
                    usedCar.getBrand(),
                    usedCar.getYear(),
                    usedCar.getPrice(),
                    usedCar.getEngineVolume(),
                    marketForUsedCar.name(),
                    usedCar.getMileage(),
                    usedCar.getConditionRate()
            );

            double cost = calculateServiceForUsedCar.calculateForUsedCar(tempCar, usedCar.getConditionRate());

            if (cost < lowestPrice) {
                lowestPrice = cost;
                bestMarket = marketForUsedCar;
            }
        }
        if (bestMarket == null) {
            throw new RuntimeException("No best market found!");
        }
        return bestMarket;
    }

}
