package com.vigyat.fitnessappprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;

public class MentalHealth_inner extends AppCompatActivity {

    private LinearLayout meditation,helpline,yoga;
    private LottieAnimationView meditationLAV, helplineLAV,yogaLAV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health_inner);

        meditation = findViewById(R.id.idLLMeditation);
        helpline = findViewById(R.id.idLLGovtPortals);
        meditationLAV = findViewById(R.id.LAVMeditation);
        helplineLAV = findViewById(R.id.idLAVGovtPortal);
        yoga = findViewById(R.id.yogaLL);
        yogaLAV = findViewById(R.id.yogaLAV);

        meditation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), Meditation.class);
                startActivity(i);

            }
        });

        helpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MentalHealth.class);
                startActivity(i);

            }
        });

        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), YogaList.class);
                startActivity(intent);
            }
        });

    }
}