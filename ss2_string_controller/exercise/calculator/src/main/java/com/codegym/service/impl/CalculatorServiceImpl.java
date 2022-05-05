package com.codegym.service.impl;

import com.codegym.service.ICaculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICaculatorService {
    @Override
    public String calculate(Double num1, Double num2, String result) {
        String finalResult = null;
        switch (result){
            case "+":
                finalResult = String.valueOf(num1+num2);
                break;
            case "-":
                finalResult = String.valueOf(num1-num2);
                break;
            case "*":
                finalResult = String.valueOf(num1*num2);
                break;
            case "/":
                if (num2 !=0){
                    finalResult = String.valueOf(num1/num2);
                    break;

                } else {
                    finalResult = "Không chia cho 0";
                    break;
                }
        }
        return finalResult;
    }
}
