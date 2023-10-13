package com.vigyat.fitnessappprototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.Manifest;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {



    int lastStepCount = 0;
    private static final int REQUEST_ACTIVITY_RECOGNITION_PERMISSION = 1;

    private LinearLayout exerciseLL,stepCounterLL;

    private LottieAnimationView exerciseLAV, counterLAV;
    private ImageView imageView;
    FirebaseAuth auth;

    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Check if the permission is granted
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACTIVITY_RECOGNITION)
                != PackageManager.PERMISSION_GRANTED) {

            // Request the permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACTIVITY_RECOGNITION},
                    REQUEST_ACTIVITY_RECOGNITION_PERMISSION);
        } else {
            // Permission is already granted, continue with your app's functionality.
        }
        auth = FirebaseAuth.getInstance();

        user = auth.getCurrentUser();
        if(user == null){
            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            finish();

        }

        SharedPreferences sharedPreferences = getSharedPreferences("StepCounterPrefs", MODE_PRIVATE);
        // Clear the shared preference when the activity is destroyed (app is closed)
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear(); // Clear all values in the shared preference
            editor.apply();
        }

        imageView = findViewById(R.id.aarogyamImg);

        exerciseLL = findViewById(R.id.idLLExercise);
        stepCounterLL = findViewById(R.id.idLLstepCounter);
        exerciseLAV = findViewById(R.id.LAVExercise);
        stepCounterLL = findViewById(R.id.idLLstepCounter);

        Intent serviceIntent = new Intent(this, StepCounterService.class);
        startService(serviceIntent);

        exerciseLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1 = new Intent(getApplicationContext(), MentalHealth_inner.class);
                startActivity(i1);


            }
        });

        stepCounterLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), StepCounter.class);
                startActivity(i);


            }
        });

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_ACTIVITY_RECOGNITION_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, continue with your app's functionality.
            } else {
                // Permission denied, handle accordingly (e.g., show a message or disable functionality).
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        int itemId = item.getItemId();

        if(itemId == R.id.Btn){
            FirebaseAuth.getInstance().signOut();
            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
