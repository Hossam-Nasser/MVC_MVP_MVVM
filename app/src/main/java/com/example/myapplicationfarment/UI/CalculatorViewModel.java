package com.example.myapplicationfarment.UI;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplicationfarment.pojo.CalculatorDatabase;

public class CalculatorViewModel extends ViewModel {
    MutableLiveData<Integer> numberDatalife= new MutableLiveData<>();

    public CalculatorDatabase getCalculatorDatabase3() {
        return new CalculatorDatabase(4, 2);
    }

    public void multiple(){
        int num1 = getCalculatorDatabase3().getNum1();
        int num2 = getCalculatorDatabase3().getNum2();
        int sum =num1 * num2;
        numberDatalife.setValue(sum);
    }


}
