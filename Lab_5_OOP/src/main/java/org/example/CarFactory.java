package org.example;

public class CarFactory {

    public static Car createCar(String type) {
        switch (type) {
            case "BMW":
                return new BMW();
            case "Audi":
                return new Audi();
            case "Ford":
                return new Ford();
            case "Volkswagen":
                return new Volkswagen();
            default:
                throw new IllegalArgumentException("Unknown car Type " + type);
        }
    }
}
