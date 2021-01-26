import java.io.IOException;

public class Calculator {
    static float calculate(float firstOperand, float secondOperand, String operator) {
        float result = 0;
        switch (operator) {
            case "addition":
                result = firstOperand + secondOperand;
                break;
            case "subtracting":
                result = firstOperand - secondOperand;
                break;
            case "multiplication":
                result = firstOperand * secondOperand;
                break;
            case "division":
                result = firstOperand / secondOperand;
        }
        return result;
    }
}

