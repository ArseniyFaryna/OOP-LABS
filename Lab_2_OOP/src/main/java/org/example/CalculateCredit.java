package org.example;

public interface CalculateCredit {

    void calculateMonthlyCredit(int year, double price, int month, double yearRate);

    void calculateInstallments(double price, int month, int firstDeposit);

}
