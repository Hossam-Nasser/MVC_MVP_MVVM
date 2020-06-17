package com.example.myapplicationfarment.UI;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplicationfarment.R;
import com.example.myapplicationfarment.pojo.CalculatorDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    Button button1;
    Button button2;
    Button button3;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.textView1)
    TextView textView1;

    CalculatorDatabase database = new CalculatorDatabase(5,6);

    Presenter presenter;

    CalculatorViewModel calculatorViewModel;

    //CalculatorDatabase database = new CalculatorDatabase();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new Presenter();

        calculatorViewModel = new ViewModelProvider(this).get(CalculatorViewModel.class);
        calculatorViewModel.numberDatalife.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer i) {
                textView3.setText(String.valueOf(i));
            }
        });

        //MVVM
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              calculatorViewModel.multiple();

            }
        });

        //MVP
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(String.valueOf(presenter.division()));

            }
        });

        //MVC
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(String.valueOf(addtion()));
                //calculatorViewModel.numberDatalife;
                //textView3.setText(onChanged());
            }
        });

    }

    public CalculatorDatabase getCalculatorDatabase1() {
        return new CalculatorDatabase(4, 2);
    }

    public int addtion() {
        int num1 = getCalculatorDatabase1().getNum1();
        int num2 = getCalculatorDatabase1().getNum2();
        return num1 + num2;
    }

   


}
