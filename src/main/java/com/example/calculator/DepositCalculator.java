package com.example.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DepositCalculator {

    public static void main(String[] args) {
        BigDecimal sum = new BigDecimal(args[0]);
        int monthCount = Integer.parseInt(args[1]);
        BigDecimal yearPercent = new BigDecimal(args[2]);
        BigDecimal monthPercent = yearPercent.divide(new BigDecimal("12"), 2, RoundingMode.HALF_UP);

        System.out.println("Initial sum: " + sum);
        System.out.println("Month count: " + monthCount);
        System.out.println("Year percent: " + yearPercent);
        System.out.println("Month percent: " + monthPercent + "\r\n");

        BigDecimal monthlyAddition;

        for(int i = 0; i < monthCount; i++){
            System.out.println("Before: " + sum);

            monthlyAddition = sum.divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP).multiply(monthPercent).setScale(2, RoundingMode.HALF_UP);

            System.out.println("To add: " + monthlyAddition);

            sum = sum.add(monthlyAddition);

            System.out.println("After: " + sum + "\r\n");
        }

        System.out.println("Result: " + sum);
    }
}
