package edu.ysu.student.calculator;


public class Calculator {
    private static final String INITIAL_VALUE = "0";

    private String input;
    private String previousInput;
    private Operator operator;
    private Boolean clearInput;
    private Boolean hasDecimal;
    private Boolean wasEqualPressed;

    public Calculator() {
        this.input = INITIAL_VALUE;
        this.previousInput = INITIAL_VALUE;
        this.clearInput = false;
        this.hasDecimal = false;
        this.wasEqualPressed = false;
    }

    public void plusMinusHandler(){
        if(this.input != "0") {
            Double x = Double.parseDouble(this.input);
            x *= -1;
            this.input = x.toString();
        }
    }

    public void percentHandler(){
        Double x = Double.parseDouble(this.input);
        Double y = Double.parseDouble(this.previousInput);
        x *= 0.01 * y;
        input = x.toString();

    }

    public void clearCalc() {
        this.input = INITIAL_VALUE;
        this.previousInput = INITIAL_VALUE;
        this.operator = null;
        this.wasEqualPressed = false;
        this.clearInput = false;
        this.hasDecimal = false;
    }

    public void inputDecimal(){
        if(!this.hasDecimal) {
            input += ".";
            this.hasDecimal = true;
        }
    }

    public void inputNumber(Integer number) {
        if (clearInput) {
            previousInput = input;
            input = number.toString();
            clearInput = false;
        } else if (input.equals(INITIAL_VALUE)) {
            input = number.toString();
        } else {
            input += number.toString();
        }
    }

    public void inputOperator(Operator operator) {
        if (this.operator != null) {
            this.calculateTotal();
        }
        this.hasDecimal = false;
        this.operator = operator;
        this.clearInput = true;
    }

    public void equals() {
        if (previousInput.equals(INITIAL_VALUE)) {
            previousInput = input;
        }
        calculateTotal();
        wasEqualPressed = true;
    }

    private void calculateTotal() {
        if(wasEqualPressed){
            previousInput = INITIAL_VALUE;
            wasEqualPressed = false;
        }
        Double total = 0.0;
        Double valueOne = Double.parseDouble(previousInput);
        Double valueTwo = Double.parseDouble(input);

        switch (operator) {
            case Add:
                total = valueOne + valueTwo;
                break;
            case Subtract:
                total = valueOne - valueTwo;
                break;
            case Multiply:
                total = valueOne * valueTwo;
                break;
            case Divide:
                total = valueOne / valueTwo;
                break;
        }

        input = total.toString();
    }

    public String getInput() {
        return this.input;
    }
}
