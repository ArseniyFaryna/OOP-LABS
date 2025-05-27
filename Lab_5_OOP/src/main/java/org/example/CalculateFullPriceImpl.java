package org.example;

public class CalculateFullPriceImpl implements CalculateFullPrice {

    @Override
    public double calculatePrice(Car car, double tax) {
        if (tax < 0 || tax > 200) {
            System.out.println("Tax should be between 0 and 100");
            return 0;
        }
        double fullPrice = car.getPrice() * car.getCustomRating() + tax;
        if (fullPrice < car.getPrice()){
            System.out.print("Something went wrong with calculating full price");
            return 0;
        }
        else{
            return fullPrice;
        }
    }
}
