package com.example.runey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SecondView extends AppCompatActivity implements View.OnClickListener {

    Button button_competition;
    Button button_parametrs;
    Button button_my_runey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_view);

        button_competition = (Button) findViewById(R.id.button_competition);
        button_parametrs = (Button) findViewById(R.id.button_parametrs);
        button_my_runey = (Button) findViewById(R.id.button_my_runey);
        button_competition.setOnClickListener(this);
        button_parametrs.setOnClickListener(this);
        button_my_runey.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_competition:
                Intent intent = new Intent(this, Competition.class);
                startActivity(intent);
                break;

            case R.id.button_parametrs:
                Intent intent1 = new Intent(this, Parametrs.class);
                startActivity(intent1);
                break;

            case R.id.button_my_runey:
                Intent intent2 = new Intent(this, MyRuney.class);
                startActivity(intent2);
                break;
        }
    }

}

