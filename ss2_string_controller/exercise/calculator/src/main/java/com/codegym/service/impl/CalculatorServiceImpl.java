package com.codegym.service.impl;

import com.codegym.service.ICaculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICaculatorService {
    @Override
    public String calculate(Double num1, Double num2, String result) {
        String final_result = null;
        switch (result){
            case "+":
                final_result = String.valueOf(num1+num2);
                break;
            case "-":
                final_result = String.valueOf(num1-num2);
                break;
            case "*":
                final_result = String.valueOf(num1*num2);
                break;
            case "/":
                if (num2 !=0){
                    final_result = String.valueOf(num1/num2);
                    break;

                } else {
                    final_result = "Không chia cho 0";
                    break;
                }
        }
        return final_result;
    }
}
