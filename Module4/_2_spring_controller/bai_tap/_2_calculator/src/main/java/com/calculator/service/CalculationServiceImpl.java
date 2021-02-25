package com.calculator.service;

public class CalculationServiceImpl implements CalculationService {

    @Override
    public double calculate(String stringNumber1, String stringNumber2, String operator) {
        double number1 = Double.parseDouble(stringNumber1);
        double number2 = Double.parseDouble(stringNumber2);
        double result = 0;
        switch (operator) {
            case "Addition":
                result = add(number1, number2);
                break;
            case "Subtraction":
                result = subtract(number1, number2);
                break;
            case "Multiplication":
                result = multiply(number1, number2);
                break;
            case "Division":
                result = divide(number1, number2);
                break;
            default:
                break;
        }
        return result;
    }

    private double add(double number1, double number2) {
        return number1 + number2;
    }

    private double subtract(double number1, double number2) {
        return number1 - number2;
    }

    private double multiply(double number1, double number2) {
        return number1 * number2;
    }

    private double divide(double number1, double number2) {
        return number1 / number2;
    }

}
