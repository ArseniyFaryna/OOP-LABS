package org.example.lab4_oop;

import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class CalculateServiceForUsedCarImpl implements CalculateServiceForUsedCar {

    @Override
    public double calculateForUsedCar(UsedCar usedCar, double conditionFactor) {

        double initialPrice = usedCar.getPrice();

        double factor = initialPrice * 0.1;

        if (conditionFactor < 0.5){
            return initialPrice + factor + 200;
        }
        else{
            return initialPrice + factor - 100;
        }
    }
}
