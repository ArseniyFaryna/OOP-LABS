package org.example;

import java.util.*;

public class Main {
    static Vehicle car = null;
    static Vehicle motorcycle = null;

    public static class VehicleHistory {
        private static final List<String> history = new ArrayList<>();

        public static void addToHistory(Vehicle vehicle) {
            if (vehicle != null) {
                history.add(vehicle.toString());
            }
        }

        public static void addInsuranceToHistory(Vehicle vehicle) {
            if (vehicle != null) {
                history.add("Insurance was calculated for " + vehicle.getBrand());
            }
        }

        public static void addCreditToHistory(Vehicle vehicle) {
            if (vehicle != null) {
                history.add("Credit was calculated for " + vehicle.getBrand());
            }
        }

        interface HistoryFilter{
            boolean accept(String string);
        }

        public static void printFilteredHistory(String stringFilter) {

            // Anonymous class
            System.out.println("Filtered history");
            HistoryFilter filter = new HistoryFilter() {
                @Override
                public boolean accept(String string) {
                    return string.contains(stringFilter);
                }
            };

            boolean found = false;
            for (String string : history) {
                if (filter.accept(string)) {
                    System.out.println(string);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Nothing to filter in history");
            }
        }

        public static void printHistory() {
            if (history.isEmpty()) {
                System.out.println("There's no history!");
            } else {
                System.out.println("There is vehicle history:");
                for (String record : history) {
                    System.out.println(record);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome it's an Automotive business!");
        System.out.println("1. Create a car or a motorcycle");
        System.out.println("2. Check customs on a car or a motorcycle");
        System.out.println("3. Get manufacturer information about a car or a motorcycle");
        System.out.println("4. Get calculated insurance on car or a motorcycle");
        System.out.println("5. Get calculated credit on a motorcycle or a car");
        System.out.println("6. Choose history type to show");
        System.out.println("7. Add something about a car or motorcycle repair");
        System.out.println("8. Show repair history");
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

                        if (year <= 0 || year >= 2025) {
                            System.out.println("Invalid year");
                            continue;
                        }

                        System.out.print("Enter price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();

                        if (price <= 0) {
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
                        VehicleHistory.addToHistory(car);
                    } else if (choice.equalsIgnoreCase("motorcycle")) {

                        System.out.print("Enter motorcycle brand: ");
                        String brand = scanner.nextLine();

                        System.out.print("Enter motorcycle model: ");
                        String model = scanner.nextLine();

                        System.out.print("Enter year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();

                        if (year <= 0 || year >= 2025) {
                            System.out.println("Invalid year");
                            continue;
                        }

                        System.out.print("Enter price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();

                        if (price <= 0) {
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
                        VehicleHistory.addToHistory(motorcycle);
                    } else{
                        System.out.println("You input wrong vehicle please try again: ");
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
                            ((Car) car).CalculateCustoms(car.getPrice(), exciseTax, money);
                        } else {
                            System.out.print("No car created yet!");
                        }
                    } else if (choice2.equalsIgnoreCase("motorcycle")) {
                        if (motorcycle != null) {
                            System.out.print("Write excise tax: ");
                            double exciseTax = scanner.nextDouble();

                            System.out.print("Write money for delivery: ");
                            double deliveryMoney = scanner.nextDouble();

                            System.out.print("Write other tax: ");
                            double otherTax = scanner.nextDouble();
                            scanner.nextLine();
                            ((Motorcycle) motorcycle).CalculateCustoms(motorcycle.getPrice(), exciseTax, deliveryMoney, otherTax);} else {
                            System.out.print("No motorcycle created yet!");
                        }
                    } else {
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
                    } else if (choice3.equalsIgnoreCase("motorcycle")) {
                        if (motorcycle != null) {
                            System.out.println("Info for " + motorcycle.getBrand() + " is");
                            motorcycle.getManufacturerInfo();
                        }
                    } else {
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

                            VehicleHistory.addInsuranceToHistory(car);
                        }
                    }
                    else if (choice4.equalsIgnoreCase("motorcycle")) {
                        if (motorcycle != null) {
                            System.out.print("Enter insurance tax: ");
                            double otherTax = scanner.nextDouble();
                            System.out.println("Customs for " + motorcycle.getBrand() + " is");
                            System.out.println("Insurance for " + motorcycle.getBrand() + " is ");
                            motorcycle.CalculateInsurance(motorcycle.getPrice(), otherTax);

                            VehicleHistory.addInsuranceToHistory(motorcycle);
                        }
                    } else {
                        System.out.println("Not motorcycle or car created yet!");
                    }
                    break;
                case 5:
                    System.out.print("Choose car or motorcycle to get credit on: ");
                    String choice5 = scanner.nextLine();

                    if (choice5.equalsIgnoreCase("car")) {
                        if (car != null) {
                            System.out.print("Please choose what type of credit you want (monthly or installment): ");
                            String creditType = scanner.nextLine();

                            if (creditType.equalsIgnoreCase("monthly")) {

                                System.out.print("Write amount of month you'll pay a credit: ");
                                int month = scanner.nextInt();

                                if (month <= 12) {
                                    System.out.println("Amount of month you'll pay a credit should be bigger than 12: ");
                                }

                                System.out.print("Write year rate for credit: ");
                                double yearRate = scanner.nextDouble();
                                car.calculateMonthlyCredit(car.getYear(), car.getPrice(), month, yearRate);
                                VehicleHistory.addCreditToHistory(car);
                            } else if (creditType.equalsIgnoreCase("installment")) {

                                System.out.print("Write amount of month you'll pay a credit: ");
                                int month = scanner.nextInt();

                                System.out.print("Write first deposit you'll pay: ");
                                int firstDeposit = scanner.nextInt();

                                car.calculateInstallments(car.getPrice(), month, firstDeposit);
                                VehicleHistory.addCreditToHistory(car);
                            }
                            else{
                                System.out.println("Wrong credit type!");
                            }
                        }
                        else{
                            System.out.println("No car created yet!");
                        }
                    }
                    else if (choice5.equalsIgnoreCase("motorcycle")) {
                        if (motorcycle != null) {
                            System.out.print("Please choose what type of credit you want (monthly or installment): ");
                            String creditType = scanner.nextLine();

                            if (creditType.equalsIgnoreCase("monthly")) {
                                System.out.print("Write amount of month you'll pay a credit: ");
                                int month = scanner.nextInt();

                                if (month <= 6 || month >= 36) {
                                    System.out.print("Amount of month you'll pay a credit should be in interval from 6 to 36: ");
                                }

                                System.out.print("Write year rate for credit: ");
                                double yearRate = scanner.nextDouble();

                                if (yearRate <= 0) {
                                    System.out.print("You write invalid year rate: ");
                                }

                                motorcycle.calculateMonthlyCredit(motorcycle.getYear(), motorcycle.getPrice(), month, yearRate);
                                VehicleHistory.addCreditToHistory(motorcycle);
                            } else if (creditType.equalsIgnoreCase("installment")) {

                                System.out.print("Write amount of month you'll pay a credit (on average from 12 to 36 month): ");
                                int month = scanner.nextInt();
                                if (month <= 6 || month > 36) {
                                    System.out.print("You write invalid year rate: ");
                                }

                                System.out.print("Write first deposit you'll pay: ");
                                int firstDeposit = scanner.nextInt();
                                if (firstDeposit <= 0) {
                                    System.out.print("You write invalid first deposit: ");
                                }

                                motorcycle.calculateInstallments(motorcycle.getPrice(), month, firstDeposit);
                                VehicleHistory.addCreditToHistory(motorcycle);
                            }
                        }
                        else{
                            System.out.println("No motorcycle created yet!");
                        }
                    }
                    else {
                        System.out.print("Wrong input! Please try again: ");
                    }
                    break;
                case 6:
                    System.out.println("1. Show all history");
                    System.out.println("2. Show insurance history");
                    System.out.println("3. Show credit history");
                    System.out.print("Choose an option: ");
                    int historyOption = scanner.nextInt();

                    switch (historyOption) {
                        case 1:
                            VehicleHistory.printHistory();
                            break;
                        case 2:
                            VehicleHistory.printFilteredHistory("Insurance");
                            break;
                        case 3:
                            VehicleHistory.printFilteredHistory("Credit");
                            break;
                        default:
                            System.out.println("Invalid option!");
                            break;
                    }
                    break;
                case 7:
                    System.out.println("Choose car or motorcycle to add repair history.");
                    String choice7 = scanner.nextLine();
                    if (choice7.equalsIgnoreCase("car")){
                        if (car != null) {
                            System.out.println("Write repair history about car!");
                            String repair = scanner.nextLine();
                            car.getRepairHistory().addHistory(repair);
                            System.out.println("Fixed added successfully!");
                        }
                        else{
                            System.out.println("No car created yet!");
                        }
                    }
                    else if (choice7.equalsIgnoreCase("motorcycle")){
                        if (motorcycle != null) {
                            System.out.println("Write repair history about motorcycle");
                            String repair = scanner.nextLine();
                            motorcycle.getRepairHistory().addHistory(repair);
                            System.out.println("Fixed added successfully!");
                        }
                        else{
                            System.out.println("No motorcycle created yet!");
                        }
                    }
                    else {
                        System.out.println("Invalid vehicle!");
                    }
                    break;
                case 8:
                    System.out.println("Choose car or motorcycle to show repair history.");
                    String choice8 = scanner.nextLine();

                    if (choice8.equalsIgnoreCase("car")){
                        if (car != null) {
                            System.out.println("Repair history for car ...");
                            car.getRepairHistory().printServiceHistory();
                        }
                        else {
                            System.out.println("No car created yet!");
                        }
                    }
                    else if (choice8.equalsIgnoreCase("motorcycle")){
                        if (motorcycle != null) {
                            System.out.println("Repair history for motto ...");
                            motorcycle.getRepairHistory().printServiceHistory();
                        }
                        else{
                            System.out.println("No motorcycle created yet!");
                        }
                    }
                    else{
                        System.out.println("Invalid vehicle!");
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