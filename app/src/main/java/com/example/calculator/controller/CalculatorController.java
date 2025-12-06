package com.example.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/api/calc")
    @ResponseBody
    public CalculationResult calc(@RequestParam double a,
                                  @RequestParam double b,
                                  @RequestParam String op) {
        double result;
        switch (op) {
            case "add": result = a + b; break;
            case "sub": result = a - b; break;
            case "mul": result = a * b; break;
            case "div": result = a / b; break;
            default: throw new IllegalArgumentException("Invalid operation: " + op);
        }
        return new CalculationResult(result);
    }

    public static class CalculationResult {
        private double result;

        public CalculationResult() {}
        public CalculationResult(double result) { this.result = result; }
        public double getResult() { return result; }
        public void setResult(double result) { this.result = result; }
    }
}