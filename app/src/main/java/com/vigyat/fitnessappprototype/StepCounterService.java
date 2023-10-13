package com.vigyat.fitnessappprototype;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.IBinder;
import android.hardware.SensorManager;
import android.widget.Toast;

public class StepCounterService extends Service implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor stepDetectorSensor;
    private int stepCount = 0; // Initialize the step count to zero

    @Override
    public void onCreate() {
        super.onCreate();
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        stepDetectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startCounting();
        return START_STICKY; // Service will be restarted if it gets terminated by the system
    }

    private void startCounting() {
        if (stepDetectorSensor == null) {
            Toast.makeText(this, "Step detector sensor not found", Toast.LENGTH_SHORT).show();
        } else {
            sensorManager.registerListener(this, stepDetectorSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            // Increment the step count for each step detected
            stepCount++;
            saveStepCountToSharedPreference(stepCount);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        sensorManager.unregisterListener(this);
    }


    private void saveStepCountToSharedPreference(int stepCount) {
        SharedPreferences sharedPreferences = getSharedPreferences("StepCounterPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("stepCount", stepCount);
        editor.apply();

        // Send a broadcast to notify the UI about the step count update
        Intent intent = new Intent("step_count_updated");
        intent.putExtra("stepCount", stepCount);
        sendBroadcast(intent);
    }
}
