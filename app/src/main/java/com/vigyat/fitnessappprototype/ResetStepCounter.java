package com.vigyat.fitnessappprototype;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class ResetStepCounter extends Worker {

    public ResetStepCounter(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        // Clear your SharedPreferences data here
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("StepCounterPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return Result.success();
    }
}
