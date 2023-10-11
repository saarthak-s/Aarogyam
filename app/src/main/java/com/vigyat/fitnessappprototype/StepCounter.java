package com.vigyat.fitnessappprototype;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import com.google.android.gms.fitness.FitnessOptions;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.auth.api.signin.GoogleSignIn;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
//import com.google.android.gms.common.api.GoogleSignInAccount;


public class StepCounter extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor stepDetectorSensor;
    private TextView stepsTV;
    private FloatingActionButton fab;
    private int stepCount = 0; // Initialize the step count to zero
    private boolean running = false; // Initialize running to false
    private int lastStepCount = 0; // Initialize the last recorded step count to zero

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_counter);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        stepDetectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        stepsTV = findViewById(R.id.TVSteps);

        fab = findViewById(R.id.idFAB);
        fab.setImageResource(R.drawable.ic_play);

        stepsTV.setText(String.valueOf(stepCount));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!running) {
                    running = true;
                    fab.setImageResource(R.drawable.ic_pause);
                    Toast.makeText(StepCounter.this, "Counter started...", Toast.LENGTH_SHORT).show();
                    startCounting();
                } else {
                    running = false;
                    fab.setImageResource(R.drawable.ic_play);
                    Toast.makeText(StepCounter.this, "Counter Pause...", Toast.LENGTH_SHORT).show();

                    lastStepCount = stepCount;
                }
            }
        });
    }

    private void startCounting() {
        running = true;

        if (stepDetectorSensor == null) {
            Toast.makeText(this, "Step detector sensor not found", Toast.LENGTH_SHORT).show();
        } else {

            stepCount = lastStepCount;
            sensorManager.registerListener(this, stepDetectorSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            if (running) {
                // Increment the step count for each step detected
                stepCount++;
                stepsTV.setText(String.valueOf(stepCount));
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}