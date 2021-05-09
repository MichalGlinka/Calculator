package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AtomicInteger check = new AtomicInteger(0);

        TextView textView = findViewById(R.id.result_view);

        Button b0 = findViewById(R.id.button_0);
        Button b1 = findViewById(R.id.button_1);
        Button b2 = findViewById(R.id.button_2);
        Button b3 = findViewById(R.id.button_3);
        Button b4 = findViewById(R.id.button_4);
        Button b5 = findViewById(R.id.button_5);
        Button b6 = findViewById(R.id.button_6);
        Button b7 = findViewById(R.id.button_7);
        Button b8 = findViewById(R.id.button_8);
        Button b9 = findViewById(R.id.button_9);
        Button bplus = findViewById(R.id.button_add);
        Button bminus = findViewById(R.id.button_substrate);
        Button bdiv = findViewById(R.id.button_divide);
        Button bmul = findViewById(R.id.button_multipy);
        Button bdot = findViewById(R.id.button_dot);
        Button beq = findViewById(R.id.button_equal);
        Button clear = findViewById(R.id.clear);
        Button back = findViewById(R.id.backspace);

        b0.setOnClickListener(e -> setNumber(textView,'0'));
        b1.setOnClickListener(e -> setNumber(textView,'1'));
        b2.setOnClickListener(e -> setNumber(textView,'2'));
        b3.setOnClickListener(e -> setNumber(textView,'3'));
        b4.setOnClickListener(e -> setNumber(textView,'4'));
        b5.setOnClickListener(e -> setNumber(textView,'5'));
        b6.setOnClickListener(e -> setNumber(textView,'6'));
        b7.setOnClickListener(e -> setNumber(textView,'7'));
        b8.setOnClickListener(e -> setNumber(textView,'8'));
        b9.setOnClickListener(e -> setNumber(textView,'9'));
        bminus.setOnClickListener(e -> {setNumber(textView,'-');
        if (check.get() == 0){
            check.getAndIncrement();
        }else {
            check.set(0);
            String s = textView.getText().toString();
            textView.setText(getEquation(s));
        }
        });
        bplus.setOnClickListener(e -> {setNumber(textView,'+');
            if (check.get() == 0){
                check.getAndIncrement();
            }else {
                check.set(0);
                String s = textView.getText().toString();
                textView.setText(getEquation(s));
            }});
        bmul.setOnClickListener(e -> {setNumber(textView,'*');
            if (check.get() == 0){
                check.getAndIncrement();
            }else {
                check.set(0);
                String s = textView.getText().toString();
                textView.setText(getEquation(s));
            }
        });
        bdiv.setOnClickListener(e -> {setNumber(textView,'/');
            if (check.get() == 0){
                check.getAndIncrement();
            }else {
                check.set(0);
                String s = textView.getText().toString();
                textView.setText(getEquation(s));
            }});
        bdot.setOnClickListener(e -> setNumber(textView,'.'));
        beq.setOnClickListener(e -> {setNumber(textView,'=');
        if(check.get() != 0){
            check.set(0);
            String s = textView.getText().toString();
            textView.setText(getEquation(s));
        }
        });
        clear.setOnClickListener(e -> textView.setText(""));
        back.setOnClickListener(e -> {
            char [] ass = textView.getText().toString().toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < ass.length - 1; i++) {
                stringBuilder.append(ass[i]);
            }
            textView.setText(stringBuilder.toString());
        });
    }

    private void setNumber(TextView textView,char c){
        String a = c + " ";
        String b = a.trim();
        textView.append(b);
    }

    private String plusChanger(String s){
        char [] c = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c1 : c) {
            if (c1=='+' || c1=='*'){
                stringBuilder.append("#");
            }else {
                stringBuilder.append(c1);
            }
        }
        return stringBuilder.toString();
    }

    private String getEquation(String source){
        String finalResult = "";

        char symbol = '-';
        char [] chars = source.toCharArray();

        for (char aChar : chars) {
            if (aChar == '-'){
                symbol = '-';
            }else if (aChar == '+'){
                symbol = '+';
            }else if (aChar == '*'){
                symbol = '*';
            }else if (aChar == '/'){
                symbol = '/';
            }
        }

        String s = equalsRemover(source);

        if(symbol == '-'){
            String [] strings = s.split("-");
            finalResult = (Double.parseDouble(strings[0]) - Double.parseDouble(strings[1])) + "";
        }else if (symbol == '+'){
            String [] strings = plusChanger(s).split("#");
            finalResult = (Double.parseDouble(strings[0]) + Double.parseDouble(strings[1])) + "";
        }else if(symbol == '*'){
            String [] strings = plusChanger(s).split("#");
            finalResult = (Double.parseDouble(strings[0]) * Double.parseDouble(strings[1])) + "";
        }else if (symbol == '/'){
            String [] strings = s.split("/");
            double number1 = Double.parseDouble(strings[0]);
            double number2 = Double.parseDouble(strings[1]);
            if (number2 == 0){
                finalResult = "Nie można dzielić przez zero";
            }else {
                finalResult = (number1 / number2) + "";
            }
        }
        return finalResult;
    }

    private String equalsRemover(String s){
        char [] c = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (char c1 : c) {
            if (c1 != '='){
                stringBuilder.append(c1);
            }
        }
        return stringBuilder.toString();
    }

}