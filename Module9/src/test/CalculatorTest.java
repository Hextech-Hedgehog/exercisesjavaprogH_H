package test;

import org.junit.jupiter.api.BeforeEach;
import repository.Calculator;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator c;

    @BeforeEach
    void setup() {
        c = (int price, double reduction) -> price - (price * reduction);
    }

    @org.junit.jupiter.api.Test
    void performCalculation() {
        assertEquals(76.5, c.performCalculation(90, 0.15));
    }
}