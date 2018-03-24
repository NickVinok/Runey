package com.example.runey;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Parametrs extends AppCompatActivity implements View.OnClickListener {

    EditText Height, Age, Weight;
    Button button_ok;
    SharedPreferences savedParam;
    final String SAVED_TEXT = "saved_text";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrs);

        Height = (EditText) findViewById(R.id.editText_height);
        Age = (EditText) findViewById(R.id.editText_age);
        Weight = (EditText) findViewById(R.id.editText_weight);

        button_ok = (Button) findViewById(R.id.button_ok);
        button_ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_ok:
                saveText();
                break;
        }

    }

    private void saveText() {
        savedParam = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = savedParam.edit();
        ed.putString(SAVED_TEXT, Height.getText().toString());
        ed.putString(SAVED_TEXT, Age.getText().toString());
        ed.putString(SAVED_TEXT, Weight.getText().toString());
        ed.commit();
        Toast.makeText(Parametrs.this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }

}
