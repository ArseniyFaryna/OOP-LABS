package org.example.lab4_oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketRecommendService implements MarketRecommendInt {

    private final CustomsCalculateService customsCalculateService;

    @Autowired
    public MarketRecommendService(CustomsCalculateService customsCalculateService) {
        this.customsCalculateService = customsCalculateService;
    }

    @Override
    public Market recommendTheBestMarket(Car car) {
        Market bestMarket = null;
        double lowestPrice = Double.MAX_VALUE;

        for (Market market : Market.values()) {
            Car tempCar = new Car(
                    car.getBrand(),
                    car.getYear(),
                    car.getPrice(),
                    car.getEngineVolume(),
                    market.name()
            );

            double cost = customsCalculateService.calculateImportFee(tempCar);

            if (cost < lowestPrice) {
                lowestPrice = cost;
                bestMarket = market;
            }
        }
        if (bestMarket == null) {
            throw new RuntimeException("No best market found!");
        }
        return bestMarket;
    }
}
