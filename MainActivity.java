package com.example.calc;

import android.app.Application;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ButtonClick buttonclick;
    TextView textview;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview=findViewById(R.id.text);
        buttonclick =new ButtonClick();
        buttonclick.setOutputView(textview);

        final Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(buttonclick);
        final Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(buttonclick);
        final Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(buttonclick);
        final Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(buttonclick);
        final Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(buttonclick);
        final Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(buttonclick);
        final Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(buttonclick);
        final Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(buttonclick);
        final Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(buttonclick);
        final Button button10 = findViewById(R.id.button10);
        button10.setOnClickListener(buttonclick);
        final Button button11 = findViewById(R.id.button11);
        button11.setOnClickListener(buttonclick);
        final Button button12 = findViewById(R.id.button12);
        button12.setOnClickListener(buttonclick);
        final Button button13 = findViewById(R.id.button13);
        button13.setOnClickListener(buttonclick);
        final Button button14 = findViewById(R.id.button14);
        button14.setOnClickListener(buttonclick);
        final Button button15 = findViewById(R.id.button15);
        button15.setOnClickListener(buttonclick);
        final Button button16 = findViewById(R.id.button16);
        button16.setOnClickListener(buttonclick);
        final Button button17 = findViewById(R.id.button17);
        button17.setOnClickListener(buttonclick);
        final Button button18 = findViewById(R.id.button18);
        button18.setOnClickListener(buttonclick);

    }
}
