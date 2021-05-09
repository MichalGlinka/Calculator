package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        bminus.setOnClickListener(e -> setNumber(textView,'-'));
        bplus.setOnClickListener(e -> setNumber(textView,'+'));
        bmul.setOnClickListener(e -> setNumber(textView,'*'));
        bdiv.setOnClickListener(e -> setNumber(textView,'/'));
        bdot.setOnClickListener(e -> setNumber(textView,'.'));
        beq.setOnClickListener(e -> setNumber(textView,'='));
    }

    private void setNumber(TextView textView,char c){
        String a = c + " ";
        String b = a.trim();
        textView.append(b);
    }
}