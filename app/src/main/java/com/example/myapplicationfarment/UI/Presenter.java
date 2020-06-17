package com.example.myapplicationfarment.UI;

import com.example.myapplicationfarment.pojo.CalculatorDatabase;

public class Presenter {


    public CalculatorDatabase getCalculatorDatabase2() {
        return new CalculatorDatabase(4, 2);
    }

    public int division() {
        int num1 = getCalculatorDatabase2().getNum1();
        int num2 = getCalculatorDatabase2().getNum2();
        return num1 / num2;
    }
}
