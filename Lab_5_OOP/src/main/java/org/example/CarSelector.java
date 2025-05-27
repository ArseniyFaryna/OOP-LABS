package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarSelector {

    private final List<String> availableCars = Arrays.asList(
            "BMW",
            "Audi",
            "Ford",
            "Volkswagen"
    );

    public void getAvailableCars() {
        System.out.println("Here is the available cars");
        for (String car : availableCars) {
            System.out.println("---" + car);
        }
    }
    public Car selectCar(Scanner scanner) {
        while(true){
            System.out.println("==== Here are a list of available cars ====");
            for (String car : availableCars) {
                System.out.println(car);
            }
            System.out.println("Enter a number to select a car or 0 to exit: ");

            int choice = scanner.nextInt();
            if (choice == 0){
                System.out.println("Exiting program...");
                return null;
            }
            else if (choice < 1 || choice > availableCars.size()){
                System.out.println("Choice is out of range");
                return null;
            }

            String selectedType = availableCars.get(choice - 1);
            return CarFactory.createCar(selectedType);
        }
    }

}
