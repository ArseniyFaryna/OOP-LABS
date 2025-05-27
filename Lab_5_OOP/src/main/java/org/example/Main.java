package org.example;

import java.util.Scanner;

public class Main {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        CarSelector selector = new CarSelector();

        Car car = selector.selectCar(scanner);
        if (car == null) {
            System.out.println("No car selected. Program exited.");
            return;
        }

        System.out.println("Selected car: " + car.getBrand());
        System.out.println("Year: " + car.getYear());
        System.out.println("Base price: " + car.getPrice());
        System.out.println("Color: " + car.getColor());
        System.out.println("Custom Rating: " + car.getCustomRating());
        System.out.println("Mileage: " + car.getMileage());

        CalculateFullPrice calculator = new CalculateFullPriceImpl();
        System.out.println("Please enter if you need delivery(y/n)");

        scanner.nextLine();
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("y")) {
            System.out.println("Enter the price of delivery: ");
            double deliveryCost = scanner.nextDouble();
            calculator = new DeliveryCostDecorator(calculator, deliveryCost);
        }
        else if (input.equalsIgnoreCase("n")) {
            System.out.println("Ok, carry this car on your back)");
        }
        else{
            System.out.println("Invalid input, please read question correctly.");
            input = scanner.nextLine();
        }

        System.out.println("Please enter insurance taxes");
        double insuranceTaxes = scanner.nextDouble();
        scanner.nextLine();
        if (insuranceTaxes >= 0 && insuranceTaxes <= 1000) {
            calculator = new InsuranceDecorator(calculator, insuranceTaxes);
        } else {
            System.out.println("Insurance taxes must be between 0 and 1000. Skipping.");
        }

        System.out.print("Please enter some taxes in your country: ");
        double someTax = scanner.nextDouble();
        double totalCost = calculator.calculatePrice(car, someTax);
        System.out.print("\nWe calculated total cost. Answer next question: ");

        ClearenceRequest request = new ClearenceRequest(car);

        NotificationService notificationService = new ConsoleNotification();
        FinalizationHandler handler = new FinalizationHandler(notificationService);

        ClearenceHandler h1 = new CheckDocuments();
        ClearenceHandler h2 = new FinalizationHandler(notificationService);
        h1.setNext(h2);

        try {
            h1.handle(request);
            System.out.print("You'll pay: " + totalCost + "\n" + "Thank you for choosing us!");
        } catch (RuntimeException ex) {
            System.out.println("Error during clearance: " + ex.getMessage());
        }

        scanner.close();
    }
}
