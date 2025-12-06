package com.example.calculator;

import com.example.calculator.controller.CalculatorController;
import com.example.calculator.controller.CalculatorController.CalculationResult;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorUnitTest {
    @Test
    public void testAdd() {
        CalculatorController ctrl = new CalculatorController();
        CalculationResult r = ctrl.calc(2.0, 3.0, "add");
        assertEquals(5.0, r.getResult(), 1e-9);
    }

    @Test
    public void testDiv() {
        CalculatorController ctrl = new CalculatorController();
        CalculationResult r = ctrl.calc(10.0, 2.0, "div");
        assertEquals(5.0, r.getResult(), 1e-9);
    }
}