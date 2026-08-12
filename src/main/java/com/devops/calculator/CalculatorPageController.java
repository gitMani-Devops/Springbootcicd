package com.devops.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorPageController {

    private final Calculator calculator;

    public CalculatorPageController(Calculator calculator) {
        this.calculator = calculator;
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam double num1,
            @RequestParam double num2,
            @RequestParam String operation,
            Model model) {

        double result = 0;

        switch (operation) {

            case "+":
                result = calculator.add(num1, num2);
                break;

            case "-":
                result = calculator.subtract(num1, num2);
                break;

            case "*":
                result = calculator.multiply(num1, num2);
                break;

            case "/":
                result = calculator.divide(num1, num2);
                break;
        }

        model.addAttribute("result", result);

        return "calculator";
    }
}