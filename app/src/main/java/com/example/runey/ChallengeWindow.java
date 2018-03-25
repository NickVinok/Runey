package com.example.runey;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ChallengeWindow extends AppCompatActivity implements SensorEventListener {
    public SensorManager sensorManager;
    public boolean activityRunning;
    public TextView textView;
    public int count1 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_window);
        textView = (TextView) findViewById(R.id.textView);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

    }

    protected void onPause(){
        super.onPause();
        activityRunning = false;
    }

    protected void onResume(){
        super.onResume();
        activityRunning = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countSensor != null){
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this, "Count sensor not available!", Toast.LENGTH_LONG).show();
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }

    public void onSensorChanged(SensorEvent event){
        if(activityRunning){
            if(count1 == 0){
                count1 = (int)event.values[0];
            }
            double db = event.values[0] - count1;
            textView.setText(String.valueOf((int) (100 - db )));
            if(Double.parseDouble(textView.getText().toString()) < 0){
                Intent intent = new Intent(ChallengeWindow.this, MyRuney.class);
                intent.putExtra("coins",100*0.0001);
                intent.putExtra("steps", 100);
                startActivity(intent);
            }
        }
    }
}
