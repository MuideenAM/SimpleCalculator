package ng.com.mamconsulting.simplecalculator;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button bttn0, bttn1, bttn2, bttn3, bttn4, bttn5, bttn6, bttn7, bttn8, bttn9, bttnDot,
            bttnMinus, bttnPlus, bttnBackspace, bttnTimes, bttnDivide, bttnEquals, bttnClearCurrent,
            bttnClearAll;
    EditText editDisplay;
    Double operand1 = 0.0, operand2 = 0.0, result = 0.0;
    String operation = "";
    Boolean operationClicked = false, equalsClicked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bttn0 = findViewById(R.id.button_zero);
        bttn1 = findViewById(R.id.button_one);
        bttn2 = findViewById(R.id.button_two);
        bttn3 = findViewById(R.id.button_three);
        bttn4 = findViewById(R.id.button_four);
        bttn5 = findViewById(R.id.button_five);
        bttn6 = findViewById(R.id.button_six);
        bttn7 = findViewById(R.id.button_seven);
        bttn8 = findViewById(R.id.button_eight);
        bttn9 = findViewById(R.id.button_nine);
        bttnDot = findViewById(R.id.button_dot);
        bttnMinus = findViewById(R.id.button_minus);
        bttnPlus = findViewById(R.id.button_plus);
        bttnBackspace = findViewById(R.id.button_backspace);
        bttnTimes = findViewById(R.id.button_times);
        bttnDivide = findViewById(R.id.button_divide);
        bttnEquals = findViewById(R.id.button_equals);
        bttnClearCurrent = findViewById(R.id.button_clear_current);
        bttnClearAll = findViewById(R.id.button_clear_all);
        editDisplay = findViewById(R.id.edit_display);
        editDisplay.setCursorVisible(false);
        editDisplay.setFocusable(false);

        bttn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNumber(bttn0);
            }
        });

        bttn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNumber(bttn1);
            }
        });

        bttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNumber(bttn2);
            }
        });

        bttn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNumber(bttn3);
            }
        });

        bttn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNumber(bttn4);
            }
        });

        bttn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNumber(bttn5);
            }
        });

        bttn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNumber(bttn6);
            }
        });

        bttn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNumber(bttn7);
            }
        });

        bttn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNumber(bttn8);
            }
        });

        bttn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNumber(bttn9);
            }
        });

        bttnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editDisplay.getText().toString().isEmpty()) {
                    editDisplay.setText("0.");
                }else if(editDisplay.getText().toString().indexOf(".") < 0){
                    displayNumber(bttnDot);
                }
            }
        });

        bttnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editDisplay.getText().toString().isEmpty()) {
                    editDisplay.setText(editDisplay.getText().toString().substring(0, editDisplay.getText().toString().length() - 1));
                }
            }
        });

        bttnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operand1 != 0){
                    operand2 = Double.parseDouble(editDisplay.getText().toString());
                    result = performOperation();
                    operand1 = result;
                    operation = "divide";
                    displayResult(result);
                    result = 0.0;
                    operationClicked = true;
                }else{
                    operand1 = Double.parseDouble(editDisplay.getText().toString());
                    operation = "divide";
                    operationClicked = true;
                }
            }
        });

        bttnTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operand1 != 0){
                    operand2 = Double.parseDouble(editDisplay.getText().toString());
                    result = performOperation();
                    operand1 = result;
                    operation = "times";
                    displayResult(result);
                    result = 0.0;
                    operationClicked = true;
                }else{
                    operand1 = Double.parseDouble(editDisplay.getText().toString());
                    operation = "times";
                    operationClicked = true;
                }
            }
        });

        bttnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operand1 != 0){
                    operand2 = Double.parseDouble(editDisplay.getText().toString());
                    result = performOperation();
                    operand1 = result;
                    operation = "plus";
                    displayResult(result);
                    result = 0.0;
                    operationClicked = true;
                }else{
                    operand1 = Double.parseDouble(editDisplay.getText().toString());
                    operation = "plus";
                    operationClicked = true;
                }
            }
        });

        bttnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operand1 != 0){
                    operand2 = Double.parseDouble(editDisplay.getText().toString());
                    result = performOperation();
                    operand1 = result;
                    operation = "minus";
                    displayResult(result);
                    result = 0.0;
                    operationClicked = true;
                }else{
                    operand1 = Double.parseDouble(editDisplay.getText().toString());
                    operation = "minus";
                    operationClicked = true;
                }
            }
        });

        bttnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equalsClicked = true;
                if(!operand1.equals(0.0)){
                    operand2 = Double.parseDouble(editDisplay.getText().toString());
                    result = performOperation();
                    displayResult(result);
                    result = 0.0;
                    operation = "";
                    operationClicked = false;
                    operand1 = 0.0;
                    operand2 = 0.0;
                }
            }
        });

        bttnClearCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editDisplay.setText("");
            }
        });

        bttnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editDisplay.setText("");
                operand1 = 0.0;
                operation = "";
                operationClicked = false;
            }
        });
    }

    private void displayNumber(Button bttn){
        if((editDisplay.getText().toString().length() < 10) && !operationClicked && !equalsClicked) {
            editDisplay.setText(editDisplay.getText().toString() + bttn.getText().toString());
        }else if(operationClicked || equalsClicked){
            editDisplay.setText(bttn.getText().toString());
            if(equalsClicked) equalsClicked = false;
            if(operationClicked) operationClicked = false;
        }
    }

    private void displayResult(Double value) {
        if(value == value.intValue()){
            editDisplay.setText(String.valueOf(value.intValue()));
        }else{
            editDisplay.setText(value.toString());
        }
    }

    private Double performOperation(){
        switch (operation){
            case "divide":
                return operand1 / operand2;
            case "times":
                return operand1 * operand2;
            case "minus":
                return operand1 - operand2;
            case "plus":
                return operand1 + operand2;
            default:
                return 0.0;
        }
    }
}
