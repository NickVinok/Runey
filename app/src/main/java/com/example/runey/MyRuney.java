package com.example.runey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

public class MyRuney extends AppCompatActivity {
    public TextView textView_coin;
    public TextView textView_steps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_runey);
        Intent intent;
        textView_steps = (TextView) findViewById(R.id.textView_steps);
        textView_coin = (TextView) findViewById(R.id.textView_coin);
        textView_coin.setText("0");
        textView_steps.setText("0");
        if(Double.parseDouble(textView_coin.getText().toString()) > 0  &&
                Double.parseDouble(textView_steps.getText().toString())>0) {
            textView_coin = (TextView) findViewById(R.id.textView_coin);
            textView_steps = (TextView) findViewById(R.id.textView_steps);

            intent = getIntent();
            String coin = intent.getStringExtra("coin");
            String step = intent.getStringExtra("step");

            Double coins = Double.parseDouble(textView_coin.getText().toString()) + Double.parseDouble(coin);
            Double steps =  Double.parseDouble(textView_steps.getText().toString()) + Double.parseDouble(step);

            textView_coin.setText(coins.toString());
            textView_steps.setText(steps.toString());
        }
    }
}
