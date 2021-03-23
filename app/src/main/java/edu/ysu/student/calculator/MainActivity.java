package edu.ysu.student.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.*;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final Calculator calculator;
    private EditText display;

    public MainActivity() {
        super();
        calculator = new Calculator();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = this.findViewById(R.id.display);

        this.findViewById(R.id.zeroButton).setOnClickListener(view -> {
            handleInput(0);
        });

        this.findViewById(R.id.oneButton).setOnClickListener(view -> {
            handleInput(1);
        });

        this.findViewById(R.id.twoButton).setOnClickListener(view -> {
            handleInput(2);
        });

        this.findViewById(R.id.threeButton).setOnClickListener(view -> {
            handleInput(3);
        });

        this.findViewById(R.id.fourButton).setOnClickListener(view -> {
            handleInput(4);
        });

        this.findViewById(R.id.fiveButton).setOnClickListener(view -> {
            handleInput(5);
        });

        this.findViewById(R.id.sixButton).setOnClickListener(view -> {
            handleInput(6);
        });

        this.findViewById(R.id.sevenButton).setOnClickListener(view -> {
            handleInput(7);
        });

        this.findViewById(R.id.eightButton).setOnClickListener(view -> {
            handleInput(8);
        });

        this.findViewById(R.id.nineButton).setOnClickListener(view -> {
            handleInput(9);
        });

        //end of number buttons

        this.findViewById(R.id.divideButton).setOnClickListener(view -> {
            handleOperator(Operator.Divide);
        });

        this.findViewById(R.id.plusButton).setOnClickListener(view -> {
            handleOperator(Operator.Add);
        });

        this.findViewById(R.id.subtractButton).setOnClickListener(view -> {
            handleOperator(Operator.Subtract);
        });

        this.findViewById(R.id.multButton).setOnClickListener(view -> {
            handleOperator(Operator.Multiply);
        });

        this.findViewById(R.id.percentButton).setOnClickListener(view -> {
            calculator.percentHandler();
            display.setText(calculator.getInput());
        });

        this.findViewById(R.id.negativeButton).setOnClickListener(view -> {
            calculator.plusMinusHandler();
            display.setText(calculator.getInput());
        });

        this.findViewById(R.id.decimalButton).setOnClickListener(view -> {
            calculator.inputDecimal();
            display.setText(calculator.getInput());
        });

        this.findViewById(R.id.acButton).setOnClickListener(view -> {
           calculator.clearCalc();
           display.setText(calculator.getInput());

        });

        this.findViewById(R.id.equalButton).setOnClickListener(view -> {
            calculator.equals();
            display.setText(calculator.getInput());
        });


       //end of onCreate function
    }

    private void handleInput(Integer number) {
        calculator.inputNumber(number);
        display.setText(calculator.getInput());
    }

    private void handleOperator(Operator operator) {
        calculator.inputOperator(operator);
        display.setText(calculator.getInput());
    }






    }
