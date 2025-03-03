package org.example;

import java.util.*;

public class Main {
    static Vehicle car = null;
    static Vehicle motorcycle = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome it's an Automotive business!");
        System.out.println("1. Create a car or a motorcycle");
        System.out.println("2. Check customs on a car or a motorcycle");
        System.out.println("3. Get manufacturer information about a car or a motorcycle");
        System.out.println("4. Get calculated insurance on car or a motorcycle");
        System.out.println("0. Exit");

        boolean running = true;
        while (running) {
            System.out.print("Enter choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Enter car or motorcycle:");
                    String choice = scanner.nextLine();

                    if (choice.equalsIgnoreCase("car")) {

                        System.out.print("Enter car brand: ");
                        String brand = scanner.nextLine();

                        System.out.print("Enter car model: ");
                        String model = scanner.nextLine();

                        System.out.print("Enter year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();

                        if (year < 0 || year > 2025) {
                            System.out.println("Invalid year");
                            continue;
                        }

                        System.out.print("Enter price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();

                        if (price < 0) {
                            System.out.println("Invalid price");
                            continue;
                        }

                        System.out.print("Enter origin country: ");
                        String originCountry = scanner.nextLine();

                        System.out.print("Enter company name: ");
                        String marketName = scanner.nextLine();

                        System.out.print("Enter delivery time: ");
                        String deliveryTime = scanner.nextLine();

                        car = new Car(brand, model, year, price, originCountry, marketName, deliveryTime);
                        System.out.println("Car created!");
                        System.out.println(car);
                    }
                    else if (choice.equalsIgnoreCase("motorcycle")) {

                        System.out.print("Enter motorcycle brand: ");
                        String brand = scanner.nextLine();

                        System.out.print("Enter motorcycle model: ");
                        String model = scanner.nextLine();

                        System.out.print("Enter year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();

                        if (year < 0 || year > 2025) {
                            System.out.println("Invalid year");
                            continue;
                        }

                        System.out.print("Enter price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();

                        if (price < 0) {
                            System.out.println("Invalid price!");
                            continue;
                        }

                        System.out.print("Enter origin country: ");
                        String originCountry = scanner.nextLine();

                        System.out.print("Enter company name: ");
                        String marketName = scanner.nextLine();

                        System.out.print("Enter delivery time: ");
                        String deliveryTime = scanner.nextLine();

                        System.out.print("Enter motorcycle condition: ");
                        String condition = scanner.nextLine();

                        System.out.print("Enter motorcycle certificate: ");
                        String certificate = scanner.nextLine();

                        motorcycle = new Motorcycle(brand, model, year, price, originCountry, marketName, deliveryTime, condition, certificate);
                        System.out.println("Motorcycle created!");
                        System.out.println(motorcycle);
                    }
                    break;
                case 2:
                    System.out.print("Choose car or motorcycle to check customs on: ");
                    String choice2 = scanner.nextLine();

                    if (choice2.equalsIgnoreCase("car")) {
                        if (car != null) {
                            System.out.print("Write excise tax in your country: ");
                            double exciseTax = scanner.nextDouble();

                            System.out.print("Write money for delivery: ");
                            double money = scanner.nextDouble();

                            scanner.nextLine();
                            ((Car)car).CalculateCustoms(car.getPrice(), exciseTax, money);
                        } else {
                            System.out.print("No car created yet!");
                        }
                    }
                    else if (choice2.equalsIgnoreCase("motorcycle")) {
                        if (motorcycle != null) {
                            System.out.print("Write excise tax: ");
                            double exciseTax = scanner.nextDouble();

                            System.out.print("Write money for delivery: ");
                            double deliveryMoney = scanner.nextDouble();

                            System.out.print("Write other tax: ");
                            double otherTax = scanner.nextDouble();
                            scanner.nextLine();
                            ((Motorcycle)motorcycle).CalculateCustoms(motorcycle.getPrice(), exciseTax, deliveryMoney, otherTax);
                        } else {
                            System.out.print("No motorcycle created yet!");
                        }
                    }
                    else{
                        System.out.println("Neither of vehicle was created!");
                    }
                    break;
                case 3:
                    System.out.println("Choose car or motorcycle to get info about a factory, " +
                            "some details with delivery and something else: ");
                    String choice3 = scanner.nextLine();

                    if (choice3.equalsIgnoreCase("car")) {
                        if (car != null) {
                            System.out.println("Info for " + car.getBrand() + " is ");
                            car.getManufacturerInfo();
                        }
                    }
                    else if (choice3.equalsIgnoreCase("motorcycle")) {
                        if (motorcycle != null) {
                            System.out.println("Info for " + motorcycle.getBrand() + " is");
                            motorcycle.getManufacturerInfo();
                        }
                    }
                    else {
                        System.out.println("Not motorcycle or car created yet!");
                    }
                    break;

                case 4:
                    System.out.println("Choose car or motorcycle to calculate insurance on:");
                    String choice4 = scanner.nextLine();

                    if (choice4.equalsIgnoreCase("car")) {
                        if (car != null) {
                            System.out.print("Enter insurance tax for a car: ");
                            double exciseTax = scanner.nextDouble();
                            System.out.println("Insurance for " + car.getBrand() + " is ");
                            car.CalculateInsurance(car.getPrice(), exciseTax);
                        }
                    }
                    else if (choice4.equalsIgnoreCase("motorcycle")) {
                        if (motorcycle != null) {
                            System.out.print("Enter insurance tax: ");
                            double otherTax = scanner.nextDouble();
                            System.out.println("Customs for " + motorcycle.getBrand() + " is");
                            System.out.println("Insurance for " + motorcycle.getBrand() + " is ");
                            motorcycle.CalculateInsurance(motorcycle.getPrice(), otherTax);
                        }
                    }
                    else {
                        System.out.println("Not motorcycle or car created yet!");
                    }
                    break;
                case 0:
                    System.out.println("Goodbye! Thank you for using our automotive business!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
    }
}
