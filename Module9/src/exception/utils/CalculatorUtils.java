package exception.utils;

import repository.Calculator;

public class CalculatorUtils {

    public static double callCalculator(Calculator c, int i, double d) {
        return c.performCalculation(i, d);
    }

}
