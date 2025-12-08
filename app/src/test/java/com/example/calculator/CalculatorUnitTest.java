package com.example.calculator;

import com.example.calculator.controller.CalculatorController;
import com.example.calculator.controller.CalculatorController.CalculationResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorUnitTest {

    private final CalculatorController ctrl = new CalculatorController();

    @Test
    public void testAdd() {
        CalculationResult r = ctrl.calc(2.0, 3.0, "add");
        assertEquals(5.0, r.getResult(), 1e-9);
    }

    @Test
    public void testDiv() {
        CalculationResult r = ctrl.calc(10.0, 2.0, "div");
        assertEquals(5.0, r.getResult(), 1e-9);
    }

    @ParameterizedTest(name = "{0} {2} {1} -> {3}")
    @CsvSource({
        "2.0, 3.0, add, 5.0",
        "5.5, 4.5, add, 10.0",
        "10.0, 3.0, sub, 7.0",
        "3.0, 4.0, mul, 12.0",
        "9.0, 3.0, div, 3.0",
        "-2.0, 5.0, add, 3.0",
        "0.1, 0.2, add, 0.30000000000000004"
    })
    public void parameterizedArithmeticTests(double a, double b, String op, double expected) {
        CalculationResult r = ctrl.calc(a, b, op);
        assertEquals(expected, r.getResult(), 1e-9);
    }

    @Test
    public void testSubtractNegativeResult() {
        CalculationResult r = ctrl.calc(2.0, 5.0, "sub");
        assertEquals(-3.0, r.getResult(), 1e-9);
    }

    @Test
    public void testMultiplyByZero() {
        CalculationResult r = ctrl.calc(123.45, 0.0, "mul");
        assertEquals(0.0, r.getResult(), 1e-9);
    }

    @Test
    public void testLargeNumbers() {
        CalculationResult r = ctrl.calc(1e9, 1e9, "add");
        assertEquals(2e9, r.getResult(), 1e-3);
    }

    @Test
    public void testUnknownOperatorThrows() {
        assertThrows(Exception.class, () -> ctrl.calc(1.0, 2.0, "mod"));
    }
}