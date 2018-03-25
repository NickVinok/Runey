package com.example.runey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondView extends AppCompatActivity implements View.OnClickListener {

    public Button button_daily;
    public Button button_parametrs;
    public Button button_my_runey;
    public Button button_competition;
    private static EditText username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_view);

        button_competition = (Button) findViewById(R.id.button_competition);
        button_parametrs = (Button) findViewById(R.id.button_parametrs);
        button_daily = (Button) findViewById(R.id.button_daily);
        button_my_runey = (Button) findViewById(R.id.button_my_runey);
        button_competition.setOnClickListener(this);
        button_parametrs.setOnClickListener(this);
        button_my_runey.setOnClickListener(this);
        button_daily.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {

        Intent intent = null;
        switch (v.getId()) {
            case R.id.button_daily:
                intent = new Intent(SecondView.this, ChallengeWindow.class);
                break;

            case R.id.button_parametrs:
                intent = new Intent(SecondView.this, Parametrs.class);
                break;

            case R.id.button_my_runey:
                intent = new Intent(SecondView.this, MyRuney.class);
                break;

            case R.id.button_competition:
                intent = new Intent(SecondView.this, Competition.class);

                break;

        }

        startActivity(intent);
    }

}

