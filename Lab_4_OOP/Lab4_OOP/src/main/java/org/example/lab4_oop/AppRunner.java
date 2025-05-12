package org.example.lab4_oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AppRunner implements CommandLineRunner {

    private final MarketRecommenderForUsedCar usedCarRecommender;
    private final CalculateServiceForUsedCar serviceForUsedCar;
    private final CustomsCalculateService calculator;
    private final MarketRecommendService recommender;
    private final InputValidation validator;

    @Autowired
    public AppRunner(MarketRecommenderForUsedCar usedCarRecommender,
                     CustomsCalculateService calculator,
                     MarketRecommendService recommender,
                     InputValidation validator,
                     CalculateServiceForUsedCar serviceForUsedCar) {
        this.usedCarRecommender = usedCarRecommender;
        this.calculator = calculator;
        this.recommender = recommender;
        this.validator = validator;
        this.serviceForUsedCar = serviceForUsedCar;
    }

    @Override
    public void run(String... args) {

        System.out.println("Let's get know how much will cost tax on car...");
        System.out.println("Choose car new or used");
        Scanner scanner = new Scanner(System.in);

        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("new")){
            String brand;
            do{
                System.out.print("Enter car brand name: ");
                brand = scanner.nextLine();
                if (!validator.isValidBrand(brand)) {
                    System.out.println("Invalid brand, please try again");
                }
            } while(!validator.isValidBrand(brand));

            int year;
            do{
                System.out.print("Enter year: ");
                year = scanner.nextInt();
                if (!validator.isValidYear(year)) {
                    System.out.println("Invalid year, please try again");
                }
            } while(!validator.isValidYear(year));

            double price;
            do{
                System.out.print("Enter price without tax: ");
                price = scanner.nextDouble();
                if (!validator.isValidPrice(price)) {
                    System.out.println("Invalid price, please try again");
                }
            } while(!validator.isValidPrice(price));

            double engineVolume;
            do{
                System.out.print("Enter engine volume: ");
                engineVolume = scanner.nextDouble();
                if (!validator.isValidEngineVolume(engineVolume)) {
                    System.out.println("Invalid engine volume, please try again");
                }
            } while(!validator.isValidEngineVolume(engineVolume));
            scanner.nextLine();

            String market;
            do{
                System.out.print("Enter market: ");
                market = scanner.nextLine();
                if (!validator.isValidMarket(market)) {
                    System.out.println("Invalid market, please try again");
                }
            } while (!validator.isValidMarket(market));
            scanner.close();

            Car car = new Car(brand, year, price, engineVolume, market);
            double taxRate = calculator.calculateImportFee(car);
            System.out.println("For market in " + market + " full price is " + taxRate);

            System.out.println("The additional money you should pay is " + (taxRate - car.getPrice()));

            Market market1 = recommender.recommendTheBestMarket(car);
            System.out.println("The best market is: " + market1);
        }

        else if (choice.equalsIgnoreCase("used")){
            String brand;
            do{
                System.out.print("Enter car brand name: ");
                brand = scanner.nextLine();
                if (!validator.isValidBrand(brand)) {
                    System.out.println("Invalid brand, please try again");
                }
            } while(!validator.isValidBrand(brand));

            int year;
            do{
                System.out.print("Enter year: ");
                year = scanner.nextInt();
                if (!validator.isValidYear(year)) {
                    System.out.println("Invalid year, please try again");
                }
            } while(!validator.isValidYear(year));

            double price;
            do{
                System.out.print("Enter price without tax: ");
                price = scanner.nextDouble();
                if (!validator.isValidPrice(price)) {
                    System.out.println("Invalid price, please try again");
                }
            } while(!validator.isValidPrice(price));

            double engineVolume;
            do{
                System.out.print("Enter engine volume: ");
                engineVolume = scanner.nextDouble();
                if (!validator.isValidEngineVolume(engineVolume)) {
                    System.out.println("Invalid engine volume, please try again");
                }
            } while(!validator.isValidEngineVolume(engineVolume));
            scanner.nextLine();

            String market;
            do{
                System.out.print("Enter market: ");
                market = scanner.nextLine();
                if (!validator.isValidMarket(market)) {
                    System.out.println("Invalid market, please try again");
                }
            } while (!validator.isValidMarket(market));

            double mileage;
            do{
                System.out.print("Enter mileage: ");
                mileage = scanner.nextDouble();
                if (!validator.isValidMileage(mileage)) {
                    System.out.println("Invalid mileage, please try again");
                }
            } while(!validator.isValidMileage(mileage));

            double conditionRate;
            do{
                System.out.print("Enter condition rate: ");
                conditionRate = scanner.nextDouble();
                if (!validator.isValidConditionRate(conditionRate)) {
                    System.out.println("Invalid condition rate, please try again");
                }
            } while(!validator.isValidConditionRate(conditionRate));

            scanner.close();
            UsedCar usedcar = new UsedCar(brand, year, price, engineVolume, market, mileage, conditionRate);
            double fullPrice = serviceForUsedCar.calculateForUsedCar(usedcar, conditionRate);
            System.out.println("For market in " + market + " full price for used car with conditionRate " + usedcar.getConditionRate() + " is " + fullPrice + "$");

            double difference = (fullPrice - usedcar.getPrice());
            if (difference > 0){
                System.out.println("The additional money(tax) you should pay is " + difference);
            }
            else{
                System.out.println("There is no additional money");
            }

            MarketForUsedCar market1 = usedCarRecommender.recommendTheBestMarketForUsedCar(usedcar);
            System.out.println("The best market is: " + market1);
        }
        else{
            System.err.println("Invalid choice, please try again");
        }
    }
}
