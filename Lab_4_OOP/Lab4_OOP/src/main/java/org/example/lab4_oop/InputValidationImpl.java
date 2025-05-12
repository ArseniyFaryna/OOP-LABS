package org.example.lab4_oop;

import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class InputValidationImpl implements InputValidation {

    @Override
    public boolean isValidBrand(String brand) {
        if (brand.isEmpty()) {
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public boolean isValidYear(int year) {
        int currentYear = LocalDate.now().getYear();
        if (year > 1900 && year < currentYear ) {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isValidEngineVolume(double engineVolume) {
        if (engineVolume > 0.0 && engineVolume < 5.5) {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isValidMarket(String market) {
        try{
            Market.valueOf(market.toUpperCase());
            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }

    @Override
    public boolean isValidPrice(double price) {
        if (price > 0 && price < Integer.MAX_VALUE) {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isValidMileage(double mileage) {
        return mileage > 0 && mileage < Integer.MAX_VALUE;
    }

    @Override
    public boolean isValidConditionRate(double conditionRate) {
        if (conditionRate > 0 && conditionRate < 10) {
            return true;
        }
        else{
            return false;
        }
    }
}
