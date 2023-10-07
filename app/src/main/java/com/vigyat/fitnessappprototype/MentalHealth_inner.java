package com.vigyat.fitnessappprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;

public class MentalHealth_inner extends AppCompatActivity {

    private LinearLayout meditation,helpline;
    private LottieAnimationView meditationLAV, helplineLAV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health_inner);

        meditation = findViewById(R.id.idLLMeditation);
        helpline = findViewById(R.id.idLLGovtPortals);
        meditationLAV = findViewById(R.id.LAVMeditation);
        helplineLAV = findViewById(R.id.idLAVGovtPortal);

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

    }
}