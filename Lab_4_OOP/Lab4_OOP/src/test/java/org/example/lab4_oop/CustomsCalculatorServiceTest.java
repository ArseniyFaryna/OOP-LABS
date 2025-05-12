package org.example.lab4_oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomsCalculatorServiceTest {

    private CustomsCalculateService calculator;
    private CalculateServiceForUsedCarImpl calculatorForUsedCar;

    @BeforeEach
    public void setUp() {
        calculator = new CustomsCalculateImplementation();
        calculatorForUsedCar = new CalculateServiceForUsedCarImpl();
    }

    @Test
    public void calculateBaseTaxes() {
        Car car = new Car("BMW", 2022, 100000, 2.0, "Germany");
        double fee = calculator.calculateImportFee(car);
        assertTrue(fee > 100000, "Fee should be greater than 100000");
    }

    @Test
    public void differentYearProducesDifferentFee() {
        Car car1 = new Car("BMW", 2018, 100000, 2.0, "Germany");
        Car car2 = new Car("BMW", 2017, 100000, 2.0, "Germany");

        assertNotEquals(
                calculator.calculateImportFee(car1),
                calculator.calculateImportFee(car2),
                "Fee should be different, because of different years"
        );
    }

    @Test
    public void checkUnknownMarket()  {
        Car badCar = new Car("INVALID", 2022, 100000, 2.0, "Unknown");

        assertThrows(IllegalArgumentException.class, () -> calculator.calculateImportFee(badCar));
    }

    @Test
    public void idealConditionForUsedCar() {
        UsedCar usedCar = new UsedCar("Audi", 2020, 10000, 3.0, "GERMANY", 50000, 0.95);

        double expectedPrice = 10900;
        double actualPrice = calculatorForUsedCar.calculateForUsedCar(usedCar, 0.95);

        assertEquals(expectedPrice, actualPrice, "Price should be close to expected based on condition");
    }

    @Test
    public void veryBadConditionForUsedCar() {
        UsedCar usedCar = new UsedCar("Toyota", 2015, 15000, 4.0, "Japan", 12000, 0.2);

        double actualPrice = usedCar.getPrice();
        double priceThatMustBe = 7500;

        assertTrue(priceThatMustBe <= actualPrice, "Price should be lesser than actual price due to condition.");
        assertTrue(priceThatMustBe >= actualPrice, "Price is ideal.");
    }

}
